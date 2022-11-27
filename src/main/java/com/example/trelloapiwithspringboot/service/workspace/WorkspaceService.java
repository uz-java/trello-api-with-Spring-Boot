package com.example.trelloapiwithspringboot.service.workspace;

import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceDTO;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:19 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface WorkspaceService {
    WorkspaceDTO save(WorkspaceCreateDTO dto);
}
