package org.lwerl.caloriesmng.web.user;

import org.lwerl.caloriesmng.model.User;

import java.util.List;

public interface AdminRest {

    User get(int id);

    User getByEmail(String email);

    List<User> getAll();

    void create(User user);

    void update(User user);

    void delete(int id);
}
