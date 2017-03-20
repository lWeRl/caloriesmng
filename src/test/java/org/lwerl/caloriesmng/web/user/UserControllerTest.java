package org.lwerl.caloriesmng.web.user;

import org.junit.Test;
import org.lwerl.caloriesmng.web.WebTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by lWeRl on 06.03.2017.
 */
public class UserControllerTest extends WebTest {
    @Test
    public void users() throws Exception {
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("userList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/userList.jsp"));
//                .andExpect(model().attribute("userList", hasSize(2)))
//                .andExpect(model().attribute("userList", hasItem(
//                        allOf(
//                                hasProperty("id", is(100000)),
//                                hasProperty("name", is("User"))
//                        )
//                )));
    }

}