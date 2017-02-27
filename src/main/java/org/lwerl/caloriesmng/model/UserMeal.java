package org.lwerl.caloriesmng.model;

import org.lwerl.caloriesmng.util.TimeUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "MEALS")
public class UserMeal extends BaseEntity {
    @Column(name="description", nullable = false)
    private String description;
    @Column(name="date", nullable = false)
    @NotNull
    private LocalDateTime date;
    @Column(name="calories", nullable = false)
    private int calories;
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public UserMeal() {
    }

    public UserMeal(Integer id, String description, LocalDateTime date, int calories) {
        super(id);
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
