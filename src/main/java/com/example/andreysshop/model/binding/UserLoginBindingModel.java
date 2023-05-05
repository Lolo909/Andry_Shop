package com.example.andreysshop.model.binding;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    @Size(min = 2, message = "Username must be more than two characters!")
    private String username;

    @Size(min = 2, message = "Password must be more than two characters!")
    private String password;

    public UserLoginBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
