package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by lWeRl on 17.02.2017.
 */
@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    UserMealRepository repository;

    public void setRepository(UserMealRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return null;
    }

    @Override
    public void delete(int id, int userId) {

    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return null;
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return null;
    }

    @Override
    public void deleteAll(int userId) {

    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return null;
    }

    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return null;
    }
}
