package com.zuhlke.avaticaclient.avaticaclient.dto;

import com.zuhlke.avaticaclient.avaticaclient.model.User;

import java.io.Serializable;

public class OrderDto implements Serializable {

    private static final long serialVersionUID = 5772608656074129388L;

    private Long id;

    private String name;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
