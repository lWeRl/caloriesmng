package org.lwerl.caloriesmng.web.meal;

import org.lwerl.caloriesmng.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

public interface MealRest {
    UserMeal get(int id);

    void delete(int id);

    List<UserMeal> getAll();

    void deleteAll();

    void update(UserMeal meal, int id);

    UserMeal create(UserMeal meal);

    List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate);
}
