package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by lWeRl on 17.02.2017.
 */
@Controller
public class MealRestImpl implements MealRest {
    @Autowired
    private UserMealService service;
}
