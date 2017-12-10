/*
    Made By ZizoNaser
    @ Sat Dec 9, 1:47pm
    Twitter: @ZizoNaser
 */
package com.obj;


public class User {
    private String name;
    private String userName;
    private String password;
    private String email;
    private String type;

    public User(String name, String userName, String password, String email, String type) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }


}