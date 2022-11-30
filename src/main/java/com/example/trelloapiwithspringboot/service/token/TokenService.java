package com.example.trelloapiwithspringboot.service.token;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:17 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface TokenService {
    String generateToken(UserDetails userDetails);

    Boolean isValid(String token);
}
