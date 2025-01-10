package com.Task_management.services.jwt;

import com.Task_management.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

     UserDetailsService userDetailsService();


     UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
