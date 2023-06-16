package com.example.gymtest.Model;

import java.util.ArrayList;

public class User {
    int admin_id;
    String admin_email;
    String admin_password;
    String admin_name;
    String trangthai;

    public User() {
        this.admin_id = admin_id;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
        this.admin_name = admin_name;
        this.trangthai = trangthai;
    }
    ArrayList<User> User;

    public ArrayList<com.example.gymtest.Model.User> getUser() {
        return User;
    }

    public void setUser(ArrayList<com.example.gymtest.Model.User> user) {
        User = user;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
}
