package org.lwerl.caloriesmng.repository.datajpa;

import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

//import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Created by lWeRl on 01.03.2017.
 */
@Repository
public class DataJpaUserRepositoryImpl implements UserRepository {

    @Resource
    ProxyUserRepository proxy;

    @Override
    public User save(User user) {
        if (user.getId() != null && proxy.findOne(user.getId()) == null) return null;
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
//        try {
//            proxy.delete(id);
//        } catch (EmptyResultDataAccessException e) {
//            return false;
//        }
//        return true;
        return proxy.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return proxy.findOne(id);
    }

    @Override
    public User getByEmail(String email) {
        return proxy.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll(new Sort(Sort.Direction.ASC, "name", "email"));
    }
}
