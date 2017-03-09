package org.lwerl.caloriesmng.web.user;


import org.lwerl.caloriesmng.model.User;

public interface UserRest {

    User get();

    void delete();

    void update(User user);
}
