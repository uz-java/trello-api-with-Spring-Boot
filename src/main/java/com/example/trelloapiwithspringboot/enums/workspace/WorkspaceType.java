package com.example.trelloapiwithspringboot.enums.workspace;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:12 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public enum WorkspaceType {
    OPERATIONS,
    SALES_CRM,
    MARKETING,
    ENGINEERING_IT,
    SMALL_BUSINESS,
    EDUCATION,
    HUMAN_RESOURCES,
    OTHER;

    public WorkspaceType getWorkspaceType(String type){
        for (WorkspaceType workspaceType : values()) {
            if (workspaceType.name().equalsIgnoreCase(type)){
                return workspaceType;
            }
        }
        return OTHER;
    }
}
