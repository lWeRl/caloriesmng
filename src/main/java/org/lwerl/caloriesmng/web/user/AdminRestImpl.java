package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AdminRestImpl implements AdminRest {
    @Autowired
    private UserService service;

    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    public User get(int id) {
        return service.get(id);
    }

    @Override
    public User getByEmail(String email) {
        return service.getByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return service.getAll();
    }

    @Override
    public void create(User user) {
        service.save(user);
    }

    @Override
    public void update(User user) {
        service.update(user);
    }

    @Override
    public void delete(int id) {
        service.delete(id);
    }
}
