package org.lwerl.caloriesmng.repository.mock;

import org.lwerl.caloriesmng.LoggerWrapper;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;

import java.util.List;

public class MockUserRepository implements UserRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepository.class);


    @Override
    public User save(User user) {
        LOG.info("Save" + user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete" + id);
        return true;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByEMail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
