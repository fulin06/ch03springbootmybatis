package com.fulin.pojo;

public class User {

    private int uid;
    private String username;
    private String password;
    private String target;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public User(int uid, String username, String password, String target) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.target = target;
    }

    public User(String username, String password, String target) {
        this.username = username;
        this.password = password;
        this.target = target;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
