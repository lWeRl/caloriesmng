package org.lwerl.caloriesmng.web;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by lWeRl on 17.03.2017.
 */
@Controller
public class RootController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:meals";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {

        model.put("error", error);
        model.put("message", message);
        return "login";
    }

//    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users() {
        return "userList";
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String meals(ModelMap model) {
        model.put("userTo", LoggedUser.get().getUser());
        return "mealList";
    }

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public String profile(ModelMap model){
        model.put("userTo", LoggedUser.get().getUser());
        return "profile";
    }

    @RequestMapping(value="/profile", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, SessionStatus session, ModelMap model){
        if (result.hasErrors()){
            model.put("userTo", LoggedUser.get().getUser());
            return "profile";
        } else {
            session.setComplete();
            user.setId(LoggedUser.get().getUser().getId());
            user.setEnabled(LoggedUser.get().getUser().isEnabled());
            user.setRoles(LoggedUser.get().getUser().getRoles());
            System.out.println(user.toString());
            service.update(user);
            return "redirect:meals";
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String registered(ModelMap model){
        model.put("userTo", new User());
        model.put("register", true);
        return "profile";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String saveRegistered(@Valid User user, BindingResult result, SessionStatus session, ModelMap model){
        if (result.hasErrors()){
            model.put("register", true);
            return "profile";
        } else {
            session.setComplete();
            user.setId(null);
            user.setEnabled(true);
            user.setRoles(Role.ROLE_USER);
            service.save(user);
            return "redirect:login?message=app.registered";
        }
    }
}
