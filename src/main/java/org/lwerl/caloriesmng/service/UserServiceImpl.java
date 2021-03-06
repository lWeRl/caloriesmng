package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.LoggedUser;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.repository.UserRepository;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Resource
    private UserRepository repository;

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) throw new NotFoundException("");
    }

    @Override
    public User get(int id) throws NotFoundException {
        User user = repository.get(id);
        if (user == null) throw new NotFoundException("");
        return user;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        try {
            User u = repository.getByEmail(email);
            if (u == null) throw new NotFoundException("");
            return u;
        } catch (Exception e) {
            throw new NotFoundException("");
        }
    }

    @Cacheable("users")
    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public User update(User user) throws NotFoundException {
        try {
            User u = repository.save(user);
            if(u==null) throw new NotFoundException("");
            return u;
        } catch (Exception e) {
            throw new NotFoundException("");
        }
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictCache() {
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = repository.getByEmail(email);
        if(u==null) throw new UsernameNotFoundException("email");
        return new LoggedUser(u);
    }
}