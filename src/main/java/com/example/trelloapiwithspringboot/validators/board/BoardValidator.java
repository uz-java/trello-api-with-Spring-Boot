package com.example.trelloapiwithspringboot.validators.board;

import com.example.trelloapiwithspringboot.configs.security.UserDetails;
import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.dtos.board.BoardChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardUpdateDTO;
import com.example.trelloapiwithspringboot.enums.board.BoardVisibilityType;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:26 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class BoardValidator extends AbstractValidator<BoardCreateDTO, BoardUpdateDTO,Long> {

    private final WorkspaceRepository workspaceRepository;
    private final BoardRepository boardRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        Board board = getBoard(id);
        validateAccessibility(board);
    }

    @Override
    public void validOnCreate(BoardCreateDTO dto) throws ValidationException {
        String name = dto.getName();
        if (Objects.isNull(name) || name.isBlank()) {
            throw new ValidationException("board name cannot be empty");
        }
        Workspace workspace = workspaceRepository.findById(dto.getWorkspaceId())
                .orElseThrow(() -> new GenericNotFoundException("Workspace not found by id : %s".formatted(dto.getWorkspaceId())));
        validateBoardWorkspace(workspace);
    }

    @Override
    public void validOnUpdate(BoardUpdateDTO dto) throws ValidationException {

    }

    private Board getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id : %s".formatted(id)));
        if (board.getIsDeleted())
            throw new ValidationException("Board not available");
        return board;
    }
    public void validateAccessibility(Board board) {
        BoardVisibilityType visibilityType = board.getVisibilityType();
        if (visibilityType.equals(BoardVisibilityType.PRIVATE)) {
            validateBoardWorkspace(board.getWorkspace());
        } else if (visibilityType.equals(BoardVisibilityType.WORKSPACE_MEMBERS)) {
            checkMembership(board);
        }
    }

    public void checkMembership(Board board) {
        boolean isNotMember = board.getWorkspace()
                .getMembers()
                .stream()
                .noneMatch(user -> user.getId().equals(getUserDetails().getId()));
        if (isNotMember)
            throw new ValidationException("you do not have permission on this workspace");
    }

    private void validateBoardWorkspace(Workspace workspace) {
        boolean workspaceNotBelongsToCurrentUser = !workspace.getCreatedBy().getId().equals(getUserDetails().getId());
        if (workspace.getIsDeleted() || workspaceNotBelongsToCurrentUser) {
            throw new ValidationException("you do not have permission on this workspace");
        }
    }

    private UserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (UserDetails) authentication.getPrincipal();
    }

    public void validateOnChangeVisibility(BoardChangeVisibilityDTO dto) {
        Long id = dto.getId();
        Board board = getBoard(id);
        if (Objects.isNull(dto.getVisibilityType()))
            throw new ValidationException("Visibility type can not be null");
        validateBoardWorkspace(board.getWorkspace());
    }

    public void validateOnDelete(Long id) {
        Board board = getBoard(id);
        validateBoardWorkspace(board.getWorkspace());
    }
}
