package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.auth.LoginRequestDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserCreateDTO;
import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.JwtResponseDTO;
import com.example.trelloapiwithspringboot.dtos.jwt.RefreshTokenRequest;
import com.example.trelloapiwithspringboot.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author "Tojaliyev Asliddin"
 * @since 26/11/22 00:42 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtResponseDTO> refreshToken(@RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(userService.refreshToken(request));
    }
}
