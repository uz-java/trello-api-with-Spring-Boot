package com.example.trelloapiwithspringboot.enums.auth;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:10 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public enum UserStatus {
    ACTIVE,
    IN_ACTIVE;

    public UserStatus getUserStatus(String status){
        for (UserStatus userStatus : values()) {
            if (userStatus.name().equalsIgnoreCase(status)){
                return userStatus;
            }
        }
        return IN_ACTIVE;
    }
}
