package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.service.UserService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: javawebinar.topjava
 */
@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(AdminAjaxController.class);
    @Resource
    private UserService service;

    {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        LOG.info("get" + id);
        return service.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        LOG.info("delete" + id);
        service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.POST)
    public void create(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
        User user = new User(id, name, email, password, Role.USER);
        if (id==0){
            user.setId(null);
            LOG.info("create " + user);
            service.save(user);
        } else {
            LOG.info("update" + user);
            service.update(user);
        }
    }
}