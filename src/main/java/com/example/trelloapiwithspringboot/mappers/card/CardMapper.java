package com.example.trelloapiwithspringboot.mappers.card;

import com.example.trelloapiwithspringboot.domains.board.Card;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import com.example.trelloapiwithspringboot.mappers.comment.CommentMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:33 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring",
        uses = {CommentMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardMapper {
    @Mapping(target = "boardColumnId",source = "boardColumn.id")
    CardDTO fromCard(Card card);
    Card fromCreateDTO(CardCreateDTO dto);
}
