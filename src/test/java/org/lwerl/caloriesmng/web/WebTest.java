package org.lwerl.caloriesmng.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.lwerl.caloriesmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by lWeRl on 06.03.2017.
 */
@ActiveProfiles({"postgres","datajpa"})
@ContextConfiguration({
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-security.xml",
})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional //откат базы после каждого теста
public abstract class WebTest {
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private FilterChainProxy restSecurityFilterChain;

    @Autowired
    UserService service;

    @PostConstruct
    void postConstruct(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(restSecurityFilterChain).build();
    }

    @Before
    public void setUp(){
        service.evictCache();
    }
}