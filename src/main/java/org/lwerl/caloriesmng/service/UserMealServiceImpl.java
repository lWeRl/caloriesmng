package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    private UserMealRepository repository;
//    @Required
    public void setRepository(UserMealRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return repository.get(id, userId);
    }

    @Override
    public void delete(int id, int userId) {
        repository.delete(id, userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return repository.getBetween(startDate, endDate, userId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public void deleteAll(int userId) {
        repository.deleteAll(userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }
}