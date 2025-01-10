package com.Task_management.controller.auth;


import com.Task_management.Entity.User;
import com.Task_management.dto.AuthenticationRequest;
import com.Task_management.dto.AuthenticationResponse;
import com.Task_management.dto.SignupRequest;
import com.Task_management.dto.UserDto;
import com.Task_management.repository.UserRepository;
import com.Task_management.services.auth.AuthService;
import com.Task_management.services.jwt.UserService;
import com.Task_management.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<?>signupUser(@RequestBody SignupRequest signupRequest){
        if(authService.hasUserWithEmail(signupRequest.getEmail()))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email already exists");
        UserDto createdUserDto=authService.signupUser(signupRequest);
        if(createdUserDto==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not created");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDto);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest){
           try{
                          authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                          authenticationRequest.getEmail(),
                          authenticationRequest.getPassword()));
             }catch (BadCredentialsException e){
                     throw new BadCredentialsException("Incorrect username or password",e);
                }
            final UserDetails userDetails=userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
            Optional<User> optionalUser=userRepository.findFirstByEmail(authenticationRequest.getEmail());
            final String jwtToken= jwtUtil.generateToken(userDetails);
            AuthenticationResponse authenticationResponse=new AuthenticationResponse();
            if(optionalUser.isPresent()) {
                authenticationResponse.setJwt(jwtToken);
                authenticationResponse.setUserId(optionalUser.get().getId());
                authenticationResponse.setUserRole(optionalUser.get().getUserRole());
            }
            return authenticationResponse;
           }


}
