package org.lwerl.caloriesmng;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.lwerl.caloriesmng.model.UserMeal;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by lWeRl on 20.02.2017.
 */
public class UserTestData {
    public static final User USER = new User(100000,"User","user@test.ru","user", Role.USER);
    public static final User ADMIN = new User(100001,"Admin","admin@test.ru","admin", Role.ADMIN);

    public static final UserMeal MEAL1 = new UserMeal(100002,  "breakfast", LocalDateTime.of(2017, 1, 6, 9, 0),500);
    public static final UserMeal MEAL2 = new UserMeal(100003, "dinner", LocalDateTime.of(2017, 1, 6, 13, 0), 1000);
    public static final UserMeal MEAL3 = new UserMeal(100004, "supper", LocalDateTime.of(2017, 1, 7, 0, 0), 600);
    public static final UserMeal MEAL4 = new UserMeal(100005,  "more dinner", LocalDateTime.of(2017, 1, 7, 13, 0),1300);
    public static final UserMeal ADMIN_MEAL = new UserMeal(100006, "admin meal", LocalDateTime.of(2017, 1, 6, 14, 0), 2000);
}
