package org.lwerl.caloriesmng.web.controller;

import org.lwerl.caloriesmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lWeRl on 05.03.2017.
 */
@Controller
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("userList", service.getAll());
        return "userList";
    }
}