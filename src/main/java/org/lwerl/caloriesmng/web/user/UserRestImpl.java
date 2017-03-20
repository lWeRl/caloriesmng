package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.service.UserService;
import org.lwerl.caloriesmng.service.UserServiceImpl;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.lwerl.caloriesmng.web.ExceptionInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.lwerl.caloriesmng.LoggedUser.LOGGED_USER;
@RestController
@RequestMapping(value = "/rest/user/")
public class UserRestImpl extends ExceptionInfoHandler implements UserRest {
    @Resource
    private UserService service;

    private static final LoggerWrapper LOG = LoggerWrapper.get(UserRestImpl.class);

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public User get() {
        LOG.info("get" + LOGGED_USER.getId());
        return service.get(LOGGED_USER.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Override
    public void delete() {
        LOG.info("delete" + LOGGED_USER.getId());
        service.delete(LOGGED_USER.getId());
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void update(@RequestBody User user) {
        LOG.info("update" + user);
        service.update(user);
    }
}
