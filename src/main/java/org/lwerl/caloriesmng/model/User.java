package org.lwerl.caloriesmng.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

//import javax.validation.constraints.Pattern;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.email=:email"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name, u.email"),
})

@Entity
@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(name = "unique_email", columnNames = "email")})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends NamedEntity {
    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";

    //@Pattern()
    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotEmpty//для строк
    @Length(min = 5)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "registered", nullable = false)
    @NotNull// для объектов
    private Date registered = new Date();

    @Enumerated(value = EnumType.STRING) //вытаскиваются как String
    @ElementCollection(fetch = FetchType.EAGER) //вытаскиваем сразу, а не проксируем
    @CollectionTable(name = "USER_ROLES", joinColumns = @JoinColumn(name = "user_id"))
    //Привязывам таблицу с указанием fk
    @Column(name = "role") //указываем что вытаскивать из указанной таблицы
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//     @JsonIgnore
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String email, String password, Role role, Role... roles) {
        super(id, name);
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.roles = EnumSet.of(role, roles);
    }

    public User(String name, String email, String password, Role role, Role... roles) {
        super(name);
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.roles = EnumSet.of(role, roles);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Role... authorities) {
        setRoles(Arrays.asList(authorities));
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = EnumSet.copyOf(roles);
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + id +
                ", email=" + email +
                ", name=" + name +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return (this.toString()).equals(user.toString());
    }
}
