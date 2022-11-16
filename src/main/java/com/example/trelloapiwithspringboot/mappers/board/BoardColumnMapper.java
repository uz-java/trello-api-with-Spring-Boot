package com.example.trelloapiwithspringboot.mappers.board;

import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;
import com.example.trelloapiwithspringboot.mappers.card.CardMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:32 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring",
        uses = {CardMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BoardColumnMapper {
    BoardColumn fromCreateDTO(BoardColumnCreateDTO dto);
    @Mapping(target="boardId",source = "board.id")
    BoardColumnDTO fromBoardColumn(BoardColumn boardColumn);
}
