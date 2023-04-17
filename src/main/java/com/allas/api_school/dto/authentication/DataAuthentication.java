package com.allas.api_school.dto.authentication;

public class DataAuthentication {

    private String username;
    private String password;

    public DataAuthentication(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public DataAuthentication() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
