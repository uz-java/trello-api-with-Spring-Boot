package com.example.trelloapiwithspringboot.service.token;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:18 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class AccessTokenService extends AbstractTokenService implements TokenService{

    @Value("${jwt.access.token.secret}")
    private String accessTokenSecret="U0RGVyQ0MzUzZnNkRyUkXiQlXjxERkhHPE9ZVUslJF4+SkhGR0pUUllVJV4=";

    @Value("${jwt.access.token.expiry.adding.amount}")
    private Integer amountToAdd = 10;

    @Value("${jwt.access.token.expiry.time.unit}")
    private TemporalUnit unit= ChronoUnit.MINUTES;

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwt(userDetails.getUsername());
    }

    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, this.accessTokenSecret);
    }

    public String getSubject(String token) {
        return super.getSubject(token, accessTokenSecret);
    }


    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.accessTokenSecret, this.amountToAdd, this.unit);
    }
}
