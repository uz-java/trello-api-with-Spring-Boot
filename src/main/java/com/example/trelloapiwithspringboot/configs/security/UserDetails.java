package com.example.trelloapiwithspringboot.configs.security;

import com.example.trelloapiwithspringboot.domains.auth.AuthRole;
import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:40 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Builder
public record UserDetails(AuthUser authUser) implements org.springframework.security.core.userdetails.UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.nonNull(authUser.getRoles())) {
            for (AuthRole role : authUser.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
               /* for (AuthPermission permission : role.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(permission.getAuthority()));
                }*/
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return authUser().getIsActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return authUser.getIsActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return authUser.getIsActive();
    }

    public Long getId() {
        return authUser.getId();
    }
}
