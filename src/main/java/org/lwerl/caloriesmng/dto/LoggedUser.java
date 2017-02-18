package org.lwerl.caloriesmng.dto;

import org.lwerl.caloriesmng.model.Role;

import java.util.Set;

public class LoggedUser {
    private int id;
    private Set<Role> roles;
    private boolean enabled;

    public int getId() {
        return id;
    }
}
