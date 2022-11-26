package com.example.trelloapiwithspringboot.service.boardColumn;

import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:16 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface BoardColumnService {
    BoardColumnDTO save(BoardColumnCreateDTO dto);
}
