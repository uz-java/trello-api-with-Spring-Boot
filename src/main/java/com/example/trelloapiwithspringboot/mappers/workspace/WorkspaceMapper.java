package com.example.trelloapiwithspringboot.mappers.workspace;

import com.example.trelloapiwithspringboot.mappers.auth.UserMapper;
import com.example.trelloapiwithspringboot.mappers.board.BoardMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:33 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring", uses = {BoardMapper.class, UserMapper.class}, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WorkspaceMapper {

}
