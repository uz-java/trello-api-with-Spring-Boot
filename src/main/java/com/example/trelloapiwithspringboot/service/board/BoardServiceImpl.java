package com.example.trelloapiwithspringboot.service.board;

import com.example.trelloapiwithspringboot.dtos.board.BoardChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
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
    @Override
    public BoardDTO save(BoardCreateDTO dto) {
        return null;
    }

    @Override
    public BoardDTO getBoard(Long id) {
        return null;
    }

    @Override
    public Void changeVisibility(BoardChangeVisibilityDTO dto) {
        return null;
    }

    @Override
    public Void deleteBoard(Long id) {
        return null;
    }
}
