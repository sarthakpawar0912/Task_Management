package com.Task_management.dto;

import com.Task_management.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private Long UserId;
    private UserRole userRole;

    public AuthenticationResponse(String jwt, UserRole userRole, Long userId) {
        this.jwt = jwt;
        this.userRole = userRole;
        UserId = userId;
    }

    public AuthenticationResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwt='" + jwt + '\'' +
                ", UserId=" + UserId +
                ", userRole=" + userRole +
                '}';
    }
}
