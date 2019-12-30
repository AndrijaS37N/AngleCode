package com.angle.angle_code.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    @NotNull
    @NotEmpty
    @Column(name = "email_address")
    private String emailAddress;
    @NotNull
    @NotEmpty
    @Column(name = "user_first_name")
    private String userFirstName;
    @NotNull
    @NotEmpty
    @Column(name = "user_last_name")
    private String userLastName;
    @NotNull
    @NotEmpty
    @Column(name = "user_password")
    private String userPassword;
    @NotNull
    @NotEmpty
    @Transient
    private String confirmedPassword;
    @NotNull
    @NotEmpty
    @Column(name = "angle_username")
    private String angleUsername;

    @Column(name = "age")
    private int age;

    @Column(name = "token")
    private String token;
    @Column(name="enabled")
    private boolean enabled;

//    @NotNull
//    @NotEmpty
    @Column(name="role")
    private String userRole;

    // Note: Quickly.
    @Column(name = "role_authorities")
    private String roleAuthorities;

    public User(String emailAddress, String userFirstName, String userLastName, String userPassword, String angleUsername, int age, String token, boolean enabled, String userRole, String roleAuthorities) {
        this.emailAddress = emailAddress;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.angleUsername = angleUsername;
        this.age = age;
        this.token = token;
        this.enabled = enabled;
        this.userRole = userRole;
        this.roleAuthorities = roleAuthorities;
    }

    public User() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getAngleUsername() {
        return angleUsername;
    }

    public void setAngleUsername(String angleUsername) {
        this.angleUsername = angleUsername;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getRoleAuthorities() {
        return roleAuthorities;
    }

    public void setRoleAuthorities(String roleAuthorities) {
        this.roleAuthorities = roleAuthorities;
    }
}
