package com.cars24.csms.data.req;

import lombok.Data;

@Data
public class SignUpReq {
    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String name;
    String password;
}
