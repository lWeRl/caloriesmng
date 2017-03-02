package org.lwerl.caloriesmng.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.UserTestData;
import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.util.DBPopulator;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {
    @Autowired
    private DBPopulator populator;
    @Resource
    private UserMealService service;

    @Before
    public void setUp() {
        populator.execute();
    }

    @Test
    public void get() throws Exception {
        UserMeal meal = service.get(100002, 100000);
        Assert.assertTrue(UserTestData.MEAL1.equals(meal));
    }

    @Test
    public void getAll() throws Exception {
        Object[] test = {UserTestData.MEAL4, UserTestData.MEAL3, UserTestData.MEAL2, UserTestData.MEAL1};
        Assert.assertArrayEquals(service.getAll(100000).toArray(), test);
    }

    @Test(expected = NotFoundException.class)
    public void delete() throws Exception {
        service.delete(100002, 100000);
        service.get(100002, 100000);
    }

    @Test(expected = NotFoundException.class)
    public void deleteException() throws Exception {
        service.delete(100000, 100000);
    }

    @Test
    public void getBetween() throws Exception {

    }

    @Test
    public void deleteAll() throws Exception {
        service.deleteAll(100000);
        Object[] test = {};
        Assert.assertArrayEquals(test, service.getAll(100000).toArray());
    }

    @Test
    public void update() throws Exception {
        service.update(new UserMeal(100002,"test", LocalDateTime.now(), 0),100000);
        Assert.assertTrue(service.get(100002,100000).getDescription().equals("test"));
    }

    @Test
    public void save() throws Exception {
        service.save(new UserMeal("test", LocalDateTime.now(),666),100000);
        service.delete(100007,100000);
    }
}