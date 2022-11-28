package com.example.trelloapiwithspringboot.service.board;

import com.example.trelloapiwithspringboot.dtos.board.BoardChangeVisibilityDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:14 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
public interface BoardService {
    BoardDTO save(BoardCreateDTO dto);

    BoardDTO getBoard(Long id);

    Void changeVisibility(BoardChangeVisibilityDTO dto);

    Void deleteBoard(Long id);
}
