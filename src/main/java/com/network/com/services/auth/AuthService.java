package com.network.com.services.auth;


import com.network.com.dto.SignupRequest;
import com.network.com.dto.UserDto;
import org.springframework.stereotype.Service;

@Service

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
