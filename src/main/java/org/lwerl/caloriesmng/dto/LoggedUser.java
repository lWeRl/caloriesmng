package org.lwerl.caloriesmng.dto;

import org.lwerl.caloriesmng.model.Role;

import java.util.Collections;
import java.util.Set;

public class LoggedUser {
    private static LoggedUser LOGGED_USER = new LoggedUser();
    private int id;
    private Set<Role> roles = Collections.singleton(Role.USER);
    private boolean enabled;

    public static LoggedUser get() {
        return LOGGED_USER;
    }

    public static int id(){
        return get().id;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean isEnabled() {
        return enabled;
    }
}