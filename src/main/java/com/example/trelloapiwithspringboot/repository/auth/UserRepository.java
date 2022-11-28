package com.example.trelloapiwithspringboot.repository.auth;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:56 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface UserRepository extends JpaRepository<AuthUser,Long> {
    Optional<AuthUser> findByEmail(String email);
}
