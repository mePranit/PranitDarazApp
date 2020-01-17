package com.example.pranitdarazapp.modal;

public class Users {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    private String userName;
    private String userEmail;
    private String userPassword;

    public Users(String _userName, String _userEmail, String _userPassword) {
        this.userName = _userName;
        this.userEmail = _userEmail;
        this.userPassword = _userPassword;
    }

}
