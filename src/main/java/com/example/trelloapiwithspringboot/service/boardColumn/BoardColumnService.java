package com.example.trelloapiwithspringboot.service.boardColumn;

import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnOrderChangeDTO;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:16 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface BoardColumnService {
    BoardColumnDTO save(BoardColumnCreateDTO dto);

    BoardColumnDTO changeOrder(BoardColumnOrderChangeDTO dto);

    Void deleteColumn(Long id);
}
