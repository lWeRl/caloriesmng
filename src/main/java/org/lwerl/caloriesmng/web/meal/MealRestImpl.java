package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MealRestImpl implements MealRest {
    @Autowired
    private UserMealService service;

    public void setService(UserMealService service) {
        this.service = service;
    }
}
