package com.example.trelloapiwithspringboot.validators.board;

import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnUpdateDTO;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.boardColumn.BoardColumnRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
    private final BoardColumnRepository columnRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(BoardColumnCreateDTO dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(BoardColumnUpdateDTO dto) throws ValidationException {

    }
}
