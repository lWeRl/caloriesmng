package org.lwerl.caloriesmng.web.controller.user;

import org.lwerl.caloriesmng.service.UserMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lWeRl on 05.03.2017.
 */
@Controller
public class MealController {
    @Autowired
    UserMealService service;

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String meals(Model model) {
        model.addAttribute("mealList", service.getAll(100000));
        return "mealList";
    }
}