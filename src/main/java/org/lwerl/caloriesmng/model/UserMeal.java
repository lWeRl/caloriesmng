package org.lwerl.caloriesmng.model;

import java.util.Date;

public class UserMeal extends BaseEntity {
    private String description;
    private Date date;
    private int calories;
    private User user;

    public UserMeal() {
    }

    public UserMeal(String description, Date date, int calories) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
