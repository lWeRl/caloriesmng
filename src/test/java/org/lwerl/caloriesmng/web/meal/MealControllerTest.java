package org.lwerl.caloriesmng.web.meal;

import org.junit.Test;
import org.lwerl.caloriesmng.UserTestData;
import org.lwerl.caloriesmng.web.WebTest;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by lWeRl on 12.03.2017.
 */
public class MealControllerTest extends WebTest {
    @Test
    public void meals() throws Exception{
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("mealList", hasSize(4)));
//                .andExpect(model().attribute("mealList", hasItem(
//                        allOf(
//                                hasProperty("id", is(UserTestData.MEAL1.getId())),
//                                hasProperty("description" , is(UserTestData.MEAL1.getDescription()))
//                        )
//                )));
    }
}