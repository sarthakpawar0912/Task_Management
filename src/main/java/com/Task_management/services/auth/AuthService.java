package com.Task_management.services.auth;

import com.Task_management.dto.SignupRequest;
import com.Task_management.dto.UserDto;

public interface AuthService {


  UserDto signupUser(SignupRequest signupRequest);


  boolean   hasUserWithEmail(String email);
}
