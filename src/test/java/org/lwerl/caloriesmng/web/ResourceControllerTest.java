package org.lwerl.caloriesmng.web;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by lWeRl on 12.03.2017.
 */
public class ResourceControllerTest extends WebTest {
    @Test
    public void resourceTest() throws Exception {
        mockMvc.perform(get("/resources/css/style.css"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.valueOf("text/css")));
    }
}