package org.lwerl.caloriesmng.service;

import org.lwerl.caloriesmng.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

public interface UserMealService {
    UserMeal get(int id, int userId);

    void delete(int id, int userId);

    List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);

    List<UserMeal> getAll(int userId);

    void deleteAll(int userId);

    UserMeal update(UserMeal meal, int userId);

    UserMeal save(UserMeal meal, int userId);
}
