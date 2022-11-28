package com.example.trelloapiwithspringboot.service.workspace;

import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceMemberDTO;
import com.example.trelloapiwithspringboot.mappers.workspace.WorkspaceMapper;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.workspace.WorkspaceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:20 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService{
    private final WorkspaceValidator workspaceValidator;
    private final WorkspaceMapper workspaceMapper;
    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;
    @Override
    public WorkspaceDTO save(WorkspaceCreateDTO dto) {
        return null;
    }

    @Override
    public List<WorkspaceDTO> getAll() {
        return null;
    }

    @Override
    public WorkspaceDTO getWorkspace(Long id) {
        return null;
    }

    @Override
    public void addMember(WorkspaceMemberDTO dto) {

    }

    @Override
    public void removeMember(WorkspaceMemberDTO dto) {

    }

    @Override
    public void changeVisibility(WorkspaceChangeVisibilityDTO dto) {

    }
}
