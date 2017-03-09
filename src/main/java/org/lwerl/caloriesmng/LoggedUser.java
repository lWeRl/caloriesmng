package org.lwerl.caloriesmng;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;

/**
 * Created by lWeRl on 06.03.2017.
 */

public class LoggedUser {
    static public final User LOGGED_USER = new User(100000, "User", "user@test.ru", "user", Role.USER);
    private User loggedUser = LOGGED_USER;

}