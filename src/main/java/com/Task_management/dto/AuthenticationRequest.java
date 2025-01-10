package com.Task_management.dto;


import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

    public AuthenticationRequest(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public AuthenticationRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
