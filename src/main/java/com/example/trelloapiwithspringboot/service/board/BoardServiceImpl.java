package com.example.trelloapiwithspringboot.service.board;

import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.dtos.board.BoardChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.mappers.board.BoardMapper;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.board.BoardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:14 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardValidator boardValidator;
    private final BoardRepository boardRepository;
    private final WorkspaceRepository workspaceRepository;
    private final BoardMapper boardMapper;
    @Override
    public BoardDTO save(BoardCreateDTO dto) {
        boardValidator.validOnCreate(dto);
        Board board = boardMapper.fromCreateDTO(dto);
        Workspace workspace = workspaceRepository.findById(dto.getWorkspaceId())
                .orElseThrow(() -> new GenericNotFoundException("Workspace not found"));
        board.setWorkspace(workspace);
        Board savedBoard = boardRepository.save(board);
        return boardMapper.fromBoard(savedBoard);
    }

    @Override
    public BoardDTO getBoard(Long id) {
        boardValidator.validateKey(id);
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id : %s".formatted(id)));
        return boardMapper.fromBoard(board);
    }

    @Override
    public void changeVisibility(BoardChangeVisibilityDTO dto) {
        boardValidator.validateOnChangeVisibility(dto);
        Board board = boardRepository.findById(dto.getId())
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id : %s".formatted(dto.getId())));
        board.setVisibilityType(dto.getVisibilityType());
        boardRepository.save(board);
    }

    @Override
    public void deleteBoard(Long id) {
        boardValidator.validateOnDelete(id);
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException(
                        "Board not found by id : %s".formatted(id))
                );
        board.setIsDeleted(true);
        boardRepository.save(board);
    }
}
