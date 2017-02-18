package org.lwerl.caloriesmng.repository.mock;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class MockUserRepository implements UserRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserRepository.class);

    @Override
    public boolean delete(int id) {
        LOG.info("delete " + id);
        return id != 0;
    }

    @Override
    public User save(User user) {
        LOG.info("save " + user);
        return user;
    }

    @Override
    public User get(int id) {
        LOG.info("get " + id);
        return null;
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll");
        return Collections.emptyList();
    }

    @Override
    public User getByEmail(String email) {
        LOG.info("getByEmail " + email);
        return null;
    }
}
