package com.example.trelloapiwithspringboot.dtos.auth;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:18 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public record UserCreateDTO(String email, String password) implements BaseGenericDTO {
}
