package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.util.exception.NotFoundException;

import java.util.List;

public interface UserService {
    User save(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    User update(User user) throws NotFoundException;
}
