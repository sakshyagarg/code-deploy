package com.project.mama.earth.service;

import com.project.mama.earth.dto.AuthenticationResponse;
import com.project.mama.earth.dto.LoginRequest;
import com.project.mama.earth.dto.RegisterRequest;
import com.project.mama.earth.model.User;
import com.project.mama.earth.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setIsAdmin(registerRequest.getIsAdmin());
        authRepository.save(user);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        User user = authRepository.findByUsername(loginRequest.getUsername()).get();
        if (loginRequest.getPassword().equals(user.getPassword()))
            return new AuthenticationResponse(user.getUsername(), user.getIsAdmin());
        return null;
    }
}