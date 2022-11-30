package com.example.trelloapiwithspringboot.mappers.board;

import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
import com.example.trelloapiwithspringboot.mappers.comment.CommentMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:32 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring",
        uses = {CommentMapper.class,
        BoardColumnMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BoardMapper {
    Board fromCreateDTO(BoardCreateDTO dto);
    @Mapping(target = "workspaceId",source = "workspace.id")
    BoardDTO fromBoard(Board board);
}
