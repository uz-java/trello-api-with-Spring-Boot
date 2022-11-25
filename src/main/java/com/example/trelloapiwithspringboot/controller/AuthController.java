package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.service.auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

   // public ResponseEntity<JwtRe>
}
