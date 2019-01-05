package com.xcy.springbootmybatisplus.entity;

/**
 * @author xcy
 * @date 2018/12/19 11:45
 * @description
 * @since V1.0.0
 */
public class User {
    private int id;
    private String user_name;
    private String user_age;
    private String user_address;

    public User() {
    }

    public User(String user_name, String user_age,String user_address) {
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_address = user_address;
    }

    public User(int id, String user_name, String user_age) {
        this.id = id;
        this.user_name = user_name;
        this.user_age = user_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
