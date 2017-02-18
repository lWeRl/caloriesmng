package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.service.UserService;
import org.lwerl.caloriesmng.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserRestImpl implements UserRest {
    @Autowired
    private UserService service;

    public UserService getService() {
        return service;
    }

    public void setService(UserServiceImpl service) {
        this.service = service;
    }
}
