package com.example.trelloapiwithspringboot.configs.encryption;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:37 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Configuration
public class Encoders {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
