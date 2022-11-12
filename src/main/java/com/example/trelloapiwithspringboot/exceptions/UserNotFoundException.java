package com.example.trelloapiwithspringboot.exceptions;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:27 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
