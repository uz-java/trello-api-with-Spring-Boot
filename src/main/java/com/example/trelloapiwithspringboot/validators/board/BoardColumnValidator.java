package com.example.trelloapiwithspringboot.validators.board;

import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnOrderChangeDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnUpdateDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.boardColumn.BoardColumnRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:27 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class BoardColumnValidator extends AbstractValidator<BoardColumnCreateDTO, BoardColumnUpdateDTO,Long> {

    private final BoardValidator boardValidator;
    private final BoardRepository boardRepository;
    private final BoardColumnRepository boardColumnRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        BoardColumn boardColumn = getBoardColumn(id);
        boardValidator.validateAccessibility(boardColumn.getBoard());
    }

    @Override
    public void validOnCreate(BoardColumnCreateDTO dto) throws ValidationException {
        String name = dto.getName();
        if (Objects.isNull(name) || name.isBlank()) {
            throw new ValidationException("Board column name can not be empty");
        }
        Board board = boardRepository.findById(dto.getBoardId())
                .orElseThrow(() -> new GenericNotFoundException("Board not found by id: %s".formatted(dto.getBoardId())));
        if (board.getIsDeleted())
            throw new ValidationException("Board not available");
        boardValidator.validateAccessibility(board);

        int boardColumnsNumber = board.getBoardColumns().size();
        if (dto.getOrder() != (boardColumnsNumber + 1))
            throw new ValidationException("Order number don't matches sequence of board columns overall (%s) and order number: %s ".formatted(boardColumnsNumber, dto.getOrder()));
    }

    @Override
    public void validOnUpdate(BoardColumnUpdateDTO dto) throws ValidationException {

    }

    protected BoardColumn getBoardColumn(Long id) {
        BoardColumn boardColumn = boardColumnRepository.findById(id).
                orElseThrow(() -> new GenericNotFoundException("Board column not found by id: %s".formatted(id)));
        if (boardColumn.getIsDeleted())
            throw new ValidationException("Board column not available with id: %s".formatted(id));
        return boardColumn;
    }

    public void validateOnChangeOrder(BoardColumnOrderChangeDTO dto) {
        Long id = dto.getId();
        BoardColumn boardColumn = getBoardColumn(id);
        Board board = boardColumn.getBoard();
        boardValidator.validateAccessibility(board);
        int boardColumnSize = board.getBoardColumns().size();
        if (dto.getOrder() < 1 || dto.getOrder() > boardColumnSize)
            throw new ValidationException("order number is not valid");
    }

    public void validateOnDelete(Long id) {
        BoardColumn boardColumn = getBoardColumn(id);
        boardValidator.validateAccessibility(boardColumn.getBoard());
        boardValidator.checkMembership(boardColumn.getBoard());
    }
}
