package org.lwerl.caloriesmng.repository;

import org.lwerl.caloriesmng.model.User;

import java.util.List;

/**
 * Created by lWeRl on 17.02.2017.
 */
public interface UserRepository {
    User save(User user);

    boolean delete(int id);

    User get(int id); //null if none

    User getByEMail(String email); //null if none

    List<User> getAll();
}
