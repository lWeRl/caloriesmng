package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.model.UserMeal;
import org.lwerl.caloriesmng.repository.UserMealRepository;
import org.lwerl.caloriesmng.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserMealServiceImpl implements UserMealService {
    @Resource
    private UserMealRepository repository;

    @Override
    public UserMeal get(int id, int userId) {
        UserMeal meal = repository.get(id, userId);
        if (meal == null) throw new NotFoundException("");
        return meal;
    }

    @Override
    public void delete(int id, int userId) {
        if (!repository.delete(id, userId)) throw new NotFoundException("");
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        if (endDate.toString().isEmpty()) endDate = LocalDateTime.now();
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