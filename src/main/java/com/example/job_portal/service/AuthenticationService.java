package com.example.job_portal.service;

import com.example.job_portal.dto.UserDto;
import com.example.job_portal.entity.User;
import com.example.job_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String register(UserDto userDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        String password = passwordEncoder.encode(userDto.getPassword());
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(password);
        userRepository.save(user);
        return "Registered Successfully!!!";
    }

    public String login(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateKey(userDto.getUsername());
        }else{
            return "invalid credentials";
        }
    }
}
