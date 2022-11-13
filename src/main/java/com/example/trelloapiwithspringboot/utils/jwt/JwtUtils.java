package com.example.trelloapiwithspringboot.utils.jwt;

import com.example.trelloapiwithspringboot.service.token.AccessTokenService;
import com.example.trelloapiwithspringboot.service.token.RefreshTokenService;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:21 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class JwtUtils {
    public static final AccessTokenService accessTokenService=new AccessTokenService();
    public static final RefreshTokenService refreshTokenService=new RefreshTokenService();
}
