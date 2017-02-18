package org.lwerl.caloriesmng.web.mock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.lwerl.caloriesmng.web.user.AdminRest;
import org.lwerl.caloriesmng.web.user.AdminRestImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AdminUserRepositoryTest {
    private static ConfigurableApplicationContext cac;
    private static AdminRest controller;

    @BeforeClass
    public static void beforeClass() {
        cac = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(cac.getBeanDefinitionNames()) + "\n");
        controller = cac.getBean(AdminRestImpl.class);
    }

    @AfterClass
    public  static void afterClass(){
        cac.close();
    }

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
