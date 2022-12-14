package com.example.trelloapiwithspringboot.service.auth;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import com.example.trelloapiwithspringboot.dtos.auth.LoginRequestDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserCreateDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.JwtResponseDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.RefreshTokenRequest;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:13 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
public interface UserService {
    JwtResponseDTO login(LoginRequestDTO dto);

    UserDTO register(UserCreateDTO dto);

    JwtResponseDTO refreshToken(RefreshTokenRequest request);

    UserDetails loadUserByUsername(String email);
}
