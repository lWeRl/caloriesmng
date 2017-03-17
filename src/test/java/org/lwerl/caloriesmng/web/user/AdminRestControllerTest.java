package org.lwerl.caloriesmng.web.user;

import org.junit.Test;
import org.lwerl.caloriesmng.UserTestData;
import org.lwerl.caloriesmng.web.WebTest;
import org.springframework.http.MediaType;

import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.lwerl.caloriesmng.model.Role.ROLE_ADMIN;
import static org.lwerl.caloriesmng.model.Role.ROLE_USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by lWeRl on 06.03.2017.
 */
public class AdminRestControllerTest extends WebTest {
    private static final String REST_URL = "/rest/admin/users/";

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get(REST_URL + "100001").with(UserTestData.httpBasic(UserTestData.ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(100001)))
                .andExpect(jsonPath("$.name", is("Admin")))
                .andExpect(jsonPath("$.email", is("admin@test.ru")))
                .andExpect(jsonPath("$.enabled", is(true)))
                .andExpect(jsonPath("$.roles", is(Collections.singletonList(ROLE_ADMIN.toString()))));
    }

    @Test
    public void getByEmailTest() throws Exception {
        mockMvc.perform(get(REST_URL + "by/?email=admin@test.ru"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(100001)))
                .andExpect(jsonPath("$.name", is("Admin")))
                .andExpect(jsonPath("$.email", is("admin@test.ru")))
                .andExpect(jsonPath("$.enabled", is(true)))
                .andExpect(jsonPath("$.roles", is(Collections.singletonList(ROLE_ADMIN.toString()))));
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(100001)))
                .andExpect(jsonPath("$[0].name", is("Admin")))
                .andExpect(jsonPath("$[0].email", is("admin@test.ru")))
                .andExpect(jsonPath("$[0].enabled", is(true)))
                .andExpect(jsonPath("$[0].roles", is(Collections.singletonList(ROLE_ADMIN.toString()))))
                .andExpect(jsonPath("$[1].id", is(100000)))
                .andExpect(jsonPath("$[1].name", is("User")))
                .andExpect(jsonPath("$[1].email", is("user@test.ru")))
                .andExpect(jsonPath("$[1].enabled", is(true)))
                .andExpect(jsonPath("$[1].roles", containsInAnyOrder(ROLE_USER.toString())));
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

}