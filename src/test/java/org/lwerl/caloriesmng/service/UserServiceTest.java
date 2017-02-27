package org.lwerl.caloriesmng.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.UserTestData;
import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.util.DBPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)

public class UserServiceTest {
    @Autowired
    DBPopulator populator;
    @Resource
    UserRepository repository;

    @Before
    public void setUp() {
        populator.execute();
    }

    @Test
    public void save() throws Exception {
        User user = repository.save(new User("Test", "test", "test", Role.USER));
        Assert.assertTrue(user.equals(repository.get(100007)));
    }

    @Test
    public void delete() throws Exception {
        Assert.assertTrue(repository.delete(100000));
    }

    @Test
    public void get() throws Exception {
        User user = repository.get(100000);
        Assert.assertTrue(user.equals(UserTestData.USER));
    }

    @Test
    public void getByEmail() throws Exception {
        User user = repository.getByEmail("user@test.ru");
        Assert.assertTrue(user.equals(UserTestData.USER));
    }

    @Test
    public void getAll() throws Exception {
        Object[] test = {UserTestData.ADMIN, UserTestData.USER};
        Assert.assertArrayEquals(repository.getAll().toArray(), test);
    }

    @Test
    public void update() throws Exception {
        User user = repository.save((new User(100000, "Test", "test", "test", Role.USER)));
        Assert.assertTrue(user.equals(repository.getByEmail("test")));
    }
}