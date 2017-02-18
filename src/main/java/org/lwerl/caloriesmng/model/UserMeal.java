package org.lwerl.caloriesmng.model;

import org.lwerl.caloriesmng.util.TimeUtil;

import java.time.LocalDateTime;

public class UserMeal extends BaseEntity {
    private String description;
    private LocalDateTime date;
    private int calories;
    private User user;

    public UserMeal() {
    }

    public UserMeal(String description, LocalDateTime date, int calories) {
        this.description = description;
        this.date = date;
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Meal: " +
                "id=" + id + " " +
                TimeUtil.toString(date) + " '" +
                description + "' " +
                "calories=" + calories;
    }
}
