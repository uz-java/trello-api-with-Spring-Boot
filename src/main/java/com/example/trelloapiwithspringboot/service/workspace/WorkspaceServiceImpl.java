package com.example.trelloapiwithspringboot.service.workspace;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceMemberDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.mappers.workspace.WorkspaceMapper;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.workspace.WorkspaceValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:20 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private final WorkspaceValidator workspaceValidator;
    private final WorkspaceMapper workspaceMapper;
    private final WorkspaceRepository workspaceRepository;
    private final UserRepository userRepository;

    @Override
    public WorkspaceDTO save(WorkspaceCreateDTO dto) {
        workspaceValidator.validOnCreate(dto);
        AuthUser authUser = userRepository.findById(dto.getUserId()).get();
        Workspace workspace = workspaceMapper.fromWorkspaceCreateDTO(dto);
        workspace.setCreatedBy(authUser);
        return workspaceMapper.fromWorkspace(workspaceRepository.save(workspace));
    }

    @Override
    public List<WorkspaceDTO> getAll() {
        UserDetails userDetails = getUserDetails();
        List<Workspace> workspaces = workspaceRepository.findAllByUser(userDetails.authUser());
        List<WorkspaceDTO> result = new ArrayList<>();
        for (Workspace workspace : workspaces) {
            WorkspaceDTO workspaceDto = workspaceMapper.fromWorkspace(workspace);
            result.add(workspaceDto);
        }
        return result;
    }

    @Override
    public WorkspaceDTO getWorkspace(Long id) throws IllegalAccessException {
        UserDetails userDetails = getUserDetails();
        Workspace workspace = workspaceRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(id)));
        boolean isNotCreator = !workspace.getCreatedBy().getId().equals(userDetails.getId());
        boolean isNotMember = !workspace.getMembers().contains(userDetails.authUser());
        if (isNotCreator && isNotMember) {
            throw new IllegalAccessException("You do not have permission to get workspace with id %s".formatted(id));
        }
        return workspaceMapper.fromWorkspace(workspace);
    }

    @Override
    public void addMember(WorkspaceMemberDTO dto) {
        workspaceValidator.validOnAddMember(dto);
        String userEmail = dto.getMemberEmail();
        Workspace workspace = workspaceRepository.findById(dto.getId()).get();
        AuthUser authUser = userRepository.findByEmail(userEmail).get();
        workspace.getMembers().add(authUser);
        workspaceRepository.save(workspace);
    }

    @Override
    public void removeMember(WorkspaceMemberDTO dto) {
        workspaceValidator.validateOnRemoveMember(dto);
        Workspace workspace = workspaceRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(dto.getId())));
        AuthUser authUser = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("User not found by email: " + dto.getMemberEmail()));
        workspace.getMembers().remove(authUser);
        workspaceRepository.save(workspace);
    }

    @Override
    public void changeVisibility(WorkspaceChangeVisibilityDTO dto) {
        workspaceValidator.validateOnChangeVisibility(dto);
        Workspace workspace = workspaceRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("workspace not found by id: %s".formatted(dto.getId())));
        workspace.setIsVisible(dto.getVisibility());
        workspaceRepository.save(workspace);
    }

    private UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }
}
