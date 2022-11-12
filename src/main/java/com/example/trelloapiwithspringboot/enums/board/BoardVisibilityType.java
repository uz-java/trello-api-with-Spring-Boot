package com.example.trelloapiwithspringboot.enums.board;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:11 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public enum BoardVisibilityType {
    PRIVATE,
    WORKSPACE_MEMBERS,
    PUBLIC;

    public BoardVisibilityType getBoardVisibility(String type){
        for (BoardVisibilityType visibilityType : values()) {
            if (visibilityType.name().equalsIgnoreCase(type)){
                return visibilityType;
            }
        }
        return PRIVATE;
    }
}
