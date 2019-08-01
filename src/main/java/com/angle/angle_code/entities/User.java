package com.angle.angle_code.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    // Note: Not required for registration for now.
    @Column(name = "user_dob")
    private Date userDateOfBirth;
    @Column(name = "token")
    private String token;

    // TODO -> Note: Add role connection.

    public User(long userId, String emailAddress, String userFirstName, String userLastName, String userPassword, String angleUsername, Date userDateOfBirth, String token) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.angleUsername = angleUsername;
        this.userDateOfBirth = userDateOfBirth;
        this.token = token;
    }

    public User() {
    }

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

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
