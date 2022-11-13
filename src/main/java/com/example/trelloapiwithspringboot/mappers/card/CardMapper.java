package com.example.trelloapiwithspringboot.mappers.card;

import com.example.trelloapiwithspringboot.mappers.comment.CommentMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:33 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring", uses = {CommentMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardMapper {
}
