package org.lwerl.caloriesmng.web.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.lwerl.caloriesmng.web.user.AdminRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({
        "classpath:spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminUserRepositorySpringTest {
    @Autowired
    private AdminRest controller;

    @Test
    public void testCreate() throws Exception{
        controller.create(new User("Name", "email@test.com", "password", Role.USER));
    }

    @Test
    public void testDelete() throws Exception{
        controller.delete(7);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteException() throws Exception{
        controller.delete(0);
    }
}
