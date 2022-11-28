package com.example.trelloapiwithspringboot.dtos.workspace;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;
import com.example.trelloapiwithspringboot.enums.workspace.WorkspaceType;
import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:04 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceCreateDTO implements BaseGenericDTO {
    private String name;
    private Long userId;
    private WorkspaceType type;
    private String description;
}
