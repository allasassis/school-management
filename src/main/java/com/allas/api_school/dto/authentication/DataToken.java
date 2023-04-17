package com.allas.api_school.dto.authentication;

public class DataToken {

    private String token;

    public DataToken(String token) {
        this.token = token;
    }

    public DataToken() {
    }

    public String getToken() {
        return token;
    }
}
