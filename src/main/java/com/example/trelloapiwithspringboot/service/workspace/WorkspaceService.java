package com.example.trelloapiwithspringboot.service.workspace;

import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceMemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:19 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
public interface WorkspaceService {
    WorkspaceDTO save(WorkspaceCreateDTO dto);

    List<WorkspaceDTO> getAll();

    WorkspaceDTO getWorkspace(Long id) throws IllegalAccessException;

    void addMember(WorkspaceMemberDTO dto);

    void removeMember(WorkspaceMemberDTO dto);

    void changeVisibility(WorkspaceChangeVisibilityDTO dto);
}
