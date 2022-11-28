package com.example.trelloapiwithspringboot.validators.workspace;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceMemberDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceUpdateDTO;
import com.example.trelloapiwithspringboot.enums.auth.UserStatus;
import com.example.trelloapiwithspringboot.enums.workspace.WorkspaceType;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:29 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class WorkspaceValidator extends AbstractValidator<WorkspaceCreateDTO, WorkspaceUpdateDTO,Long> {
    private final UserRepository userRepository;
    private final WorkspaceRepository workspaceRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        workspaceRepository.findById(id).
                orElseThrow(() -> new ValidationException("Workspace not found by id : %s".formatted(id)));
    }

    @Override
    public void validOnCreate(WorkspaceCreateDTO dto) throws ValidationException {
        String name = dto.getName();
        WorkspaceType type = dto.getType();
        Long userId = dto.getUserId();
        if (Objects.isNull(name) || name.isBlank())
            throw new ValidationException("workspace name cannot be empty");
        if (Objects.isNull(type))
            throw new ValidationException("workspace type cannot be null");
        userRepository.findById(userId)
                .orElseThrow(() -> new ValidationException("User not found by id: %s".formatted(userId)));
    }

    @Override
    public void validOnUpdate(WorkspaceUpdateDTO dto) throws ValidationException {

    }

    public void validOnAddMember(WorkspaceMemberDTO dto) throws ValidationException {
        Workspace workspace = workspaceRepository.findById(dto.getId()).
                orElseThrow(() -> new ValidationException("Workspace not found by id : %s".formatted(dto.getId())));
        String userEmail = dto.getMemberEmail();
        AuthUser authUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new GenericNotFoundException(
                        "user not found by email: %s".formatted(userEmail)));
        if (!authUser.getIsActive() || authUser.getStatus().equals(UserStatus.IN_ACTIVE))
            throw new GenericNotFoundException("user not found by email: %s".formatted(userEmail));
        if (workspace.getCreatedBy().equals(authUser) || workspace.getMembers().contains(authUser))
            throw new IllegalArgumentException("already member");
    }

    public void validateOnChangeVisibility(WorkspaceChangeVisibilityDTO dto) {
        Workspace workspace = workspaceRepository.findById(dto.getId()).
                orElseThrow(() -> new ValidationException("Workspace not found by id : %s".formatted(dto.getId())));
        validateWorkspaceCreator(workspace);
    }

    public void validateWorkspaceCreator(Workspace workspace) {
        boolean isUserNotCreatorOfWorkspace = !workspace.getCreatedBy().getId().equals(getUserDetails().getId());
        if (isUserNotCreatorOfWorkspace)
            throw new ValidationException("You do not have permission to change visibility");
    }

    private UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    public void validateOnRemoveMember(WorkspaceMemberDTO dto) {
        Workspace workspace = workspaceRepository.findById(dto.getId()).
                orElseThrow(() -> new ValidationException("Workspace not found by id : %s".formatted(dto.getId())));
        validateWorkspaceCreator(workspace);
        AuthUser authUser = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("User not found by email: " + dto.getMemberEmail()));
        if (!workspace.getMembers().contains(authUser))
            throw new ValidationException("User is not member of workspace with id: %s, user: %s ".formatted(dto.getId(), dto.getMemberEmail()));
    }
}
