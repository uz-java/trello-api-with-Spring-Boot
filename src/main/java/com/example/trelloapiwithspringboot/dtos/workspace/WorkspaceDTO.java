package com.example.trelloapiwithspringboot.dtos.workspace;

import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
import com.example.trelloapiwithspringboot.enums.workspace.WorkspaceType;
import lombok.*;

import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:05 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceDTO {
    private Long id;
    private String name;
    private Long createdBy;
    private WorkspaceType workspaceType;
    private String description;
    private Boolean isVisible;
    private Set<BoardDTO> boardDTOS;
    private Set<UserDTO> members;
}
