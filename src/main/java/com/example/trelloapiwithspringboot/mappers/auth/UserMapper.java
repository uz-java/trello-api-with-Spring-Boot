package com.example.trelloapiwithspringboot.mappers.auth;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:31 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO fromUser(AuthUser authUser);
}
