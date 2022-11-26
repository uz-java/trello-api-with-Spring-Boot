package com.example.trelloapiwithspringboot.service.auth;

import com.example.trelloapiwithspringboot.dtos.auth.LoginRequestDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserCreateDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.JwtResponseDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.RefreshTokenRequest;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:13 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface UserService {
    JwtResponseDTO login(LoginRequestDTO dto);

    UserDTO register(UserCreateDTO dto);

    JwtResponseDTO refreshToken(RefreshTokenRequest request);
}
