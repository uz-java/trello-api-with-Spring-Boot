package com.example.trelloapiwithspringboot.validators.board;

import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardUpdateDTO;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.board.BoardRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    }

    @Override
    public void validOnCreate(BoardCreateDTO dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(BoardUpdateDTO dto) throws ValidationException {

    }
}
