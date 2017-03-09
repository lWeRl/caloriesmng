package org.lwerl.caloriesmng.web.user;

import org.junit.Test;
import org.lwerl.caloriesmng.web.WebTest;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

/**
 * Created by lWeRl on 06.03.2017.
 */
public class AdminRestControllerTest extends WebTest{
    private static final String REST_URL = "/rest/admin/users/";
    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/rest/admin/users/100001"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
                //.andExpect(Mat)
    }

    @Test
    public void getByEmailTest() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

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