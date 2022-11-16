package com.example.trelloapiwithspringboot.dtos.workspace;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:03 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceChangeVisibilityDTO {
    private Long id;
    private Boolean visibility;
}
