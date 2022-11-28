package com.example.trelloapiwithspringboot.configs.security;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:40 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Builder
public record UserDetails(AuthUser authUser) implements org.springframework.security.core.userdetails.UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
