package com.angle.angle_code.entities;

import java.util.Date;

public class User {

    private long userId;
    private String emailAddress;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String confirmedPassword;
    private String angleUsername;
    private Date userDateOfBirth;
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
