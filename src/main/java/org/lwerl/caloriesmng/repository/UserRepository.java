package org.lwerl.caloriesmng.repository;

import org.lwerl.caloriesmng.model.User;

import java.util.List;


public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id); //null if none

    User getByEMail(String email); //null if none

    List<User> getAll();
}
