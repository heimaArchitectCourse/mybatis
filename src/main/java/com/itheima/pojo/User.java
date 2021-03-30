package com.itheima.pojo;


import java.io.Serializable;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */

public class User implements Serializable{

    private Integer id;
    private String username;
    private String address;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public User(Integer id, String username, String address, String name) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
