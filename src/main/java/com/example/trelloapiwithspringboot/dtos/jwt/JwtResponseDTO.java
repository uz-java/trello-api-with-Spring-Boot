package com.example.trelloapiwithspringboot.dtos.jwt;

/**
 * @author "Tojaliyev Asliddin"
 * @since 26/11/22 00:48 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public record JwtResponseDTO(String accessToken,
                             String refreshToken,
                             String tokenType) {
}
