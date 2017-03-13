package org.lwerl.caloriesmng.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.lwerl.caloriesmng.util.TimeUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = UserMeal.GET, query = "SELECT m FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.date DESC"),
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId"),
        @NamedQuery(name = UserMeal.DELETE_ALL, query = "DELETE FROM UserMeal m WHERE m.user.id=:userId"),
        @NamedQuery(name = UserMeal.GET_BETWEEN, query = "SELECT m FROM UserMeal m WHERE m.user.id=:userId AND m.date>=:startDate and m.date<:endDate ORDER BY m.date DESC"),
//        @NamedQuery(name = UserMeal.UPDATE, query = "UPDATE UserMeal m SET m.date = :date, m.calories= :calories, m.description=:desc WHERE m.id=:id AND m.user.id=:userId")
})

@Entity
@Table(name = "MEALS")
public class UserMeal extends BaseEntity {
    public static final String GET = "UserMeal.get";
    public static final String ALL_SORTED = "UserMeal.getAll";
    public static final String DELETE = "UserMeal.delete";
    public static final String DELETE_ALL = "UserMeal.deleteAll";
    public static final String GET_BETWEEN = "UserMeal.getBetween";
//    public static final String UPDATE = "UserMeal.update";


    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDateTime date;
    @Column(name = "calories", nullable = false)
    private int calories;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public UserMeal() {
    }

    public UserMeal(Integer id, String description, LocalDateTime date, int calories) {
        super(id);
        this.description = description;
        this.date = date;
        this.calories = calories;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserMeal userMeal = (UserMeal) o;
        return (this.toString()).equals(userMeal.toString());
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + date.hashCode();
        return result;
    }
}
