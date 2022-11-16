package com.example.trelloapiwithspringboot.dtos.auth;

import com.example.trelloapiwithspringboot.domains.auth.AuthRole;
import com.example.trelloapiwithspringboot.dtos.base.GenericDTO;
import com.example.trelloapiwithspringboot.enums.auth.UserStatus;
import lombok.*;

import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:18 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO extends GenericDTO {
    private String email;
    private Set<AuthRole> roles;
    private UserStatus status;
    private Boolean isActive;

    @Builder(builderMethodName = "childBuilder")
    public UserDTO(Long id, String email, Set<AuthRole> roles, UserStatus status, Boolean isActive) {
        super(id);
        this.email = email;
        this.roles = roles;
        this.status = status;
        this.isActive = isActive;
    }
}
