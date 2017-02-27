package org.lwerl.caloriesmng.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.util.DBPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)

public class UserMealServiceTest {
    @Autowired
    DBPopulator populator;
    @Resource
    UserMealRepository repository;

    @Before
    public void setUp() {
        populator.execute();
    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getBetween() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void deleteAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }
}