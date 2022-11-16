package com.example.trelloapiwithspringboot.dtos.workspace;

import com.example.trelloapiwithspringboot.dtos.base.GenericDTO;
import com.example.trelloapiwithspringboot.enums.workspace.WorkspaceType;
import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:06 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceUpdateDTO extends GenericDTO {
    private Long id;
    private String name;
    private WorkspaceType workspaceType;
    private String description;
}
