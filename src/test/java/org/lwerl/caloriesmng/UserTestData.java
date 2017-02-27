package org.lwerl.caloriesmng;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Created by lWeRl on 20.02.2017.
 */
public class UserTestData {
    public static final User USER = new User(100000,"User","user@test.ru","user", Role.USER);
    public static final User ADMIN = new User(100001,"Admin","admin@test.ru","admin", Role.ADMIN);
}
