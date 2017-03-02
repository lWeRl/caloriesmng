package org.lwerl.caloriesmng.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.UserTestData;
import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.util.DBPopulator;
import org.lwerl.caloriesmng.util.JpaUtil;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
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
    UserService service;
    @Resource
    JpaUtil jpaUtil;

    @Before
    public void setUp() {
        populator.execute();
        jpaUtil.clear2ndLevelHibernateCache();
    }

    @Test
    public void get() throws Exception {
        User user = service.get(100000);
        System.out.println(user);
        System.out.println(UserTestData.USER);
        Assert.assertTrue(user.equals(UserTestData.USER));
    }

    @Test(expected = NotFoundException.class)
    public void getException() throws Exception {
        User user = service.get(99999);
    }

    @Test
    public void getByEmail() throws Exception {
        User user = service.getByEmail("user@test.ru");
        Assert.assertTrue(user.equals(UserTestData.USER));
    }

    @Test(expected = NotFoundException.class)
    public void getByEmailException() throws Exception {
        service.getByEmail("null@null.ru");
    }

    @Test
    public void getAll() throws Exception {
        Object[] test = {UserTestData.ADMIN, UserTestData.USER};
        Assert.assertArrayEquals(service.getAll().toArray(), test);
    }

    @Test(expected = NotFoundException.class)
    public void delete() throws Exception {
        service.delete(100000);
        service.get(100000);
    }

    @Test(expected = NotFoundException.class)
    public void deleteException() throws Exception {
        service.delete(99999);
    }

    @Test
    public void save() throws Exception {
        User user = service.save(new User("Test", "test", "test", Role.USER));
        Assert.assertTrue(user.equals(service.get(100007)));
    }

    @Test
    public void update() throws Exception {
        User user = service.update((new User(100000, "Test", "test", "test", Role.USER)));
        Assert.assertTrue(user.equals(service.getByEmail("test")));
    }

    @Test(expected = NotFoundException.class)
    public void updateException() throws Exception {
        service.update((new User(99999, "Test", "test", "test", Role.USER)));
    }
}