package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminRestImpl implements AdminRest {
    @Autowired
    private UserService service;

    public void setService(UserService service) {
        this.service = service;
    }
}
