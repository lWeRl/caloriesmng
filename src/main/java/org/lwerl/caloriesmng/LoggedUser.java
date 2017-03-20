package org.lwerl.caloriesmng;

import org.lwerl.caloriesmng.model.Role;
import org.lwerl.caloriesmng.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/**
 * Created by lWeRl on 06.03.2017.
 */

public class LoggedUser implements UserDetails{
    static public final User LOGGED_USER = new User(100000, "User", "user@test.ru", "user", Role.ROLE_USER);
    private User loggedUser;
//    private int id;
//    private Set<Role> roles;
//    private boolean enabled;

    public static Integer id(){
        return get().loggedUser.getId();
//        return LOGGED_USER.getId();
    }

    public LoggedUser(User u){
        loggedUser = u;
//        id = u.getId();
//        roles = u.getRoles();
//        enabled = u.isEnabled();
    }

    public static LoggedUser safeGet(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null) return null;
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser)? (LoggedUser) user : null;
    }

    public static LoggedUser get(){
        LoggedUser user = safeGet();
        Objects.requireNonNull(user, "No authorized user found");
        return user;
    }

    public User getUser(){
        return loggedUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return loggedUser.getRoles();
    }

    @Override
    public String getPassword() {
        return loggedUser.getPassword();
    }

    @Override
    public String getUsername() {
        return loggedUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return loggedUser.isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return loggedUser.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return loggedUser.isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return loggedUser.isEnabled();
    }
}