package com.fulin.password;

import org.apache.shiro.crypto.hash.Md5Hash;

public class AddPassword {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddPassword(String password){
        Md5Hash md5Hash = new Md5Hash(password);
        this.password=md5Hash.toString();
    }
}
