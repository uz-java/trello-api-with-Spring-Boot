package com.example.trelloapiwithspringboot.mappers.comment;

import com.example.trelloapiwithspringboot.domains.comment.Comment;
import com.example.trelloapiwithspringboot.dtos.comment.CommentCreateDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentDTO;
import org.mapstruct.Mapper;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:33 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Mapper(componentModel = "spring")
public interface CommentMapper {
    Comment fromCreateDTO(CommentCreateDTO dto);

    CommentDTO fromComment(Comment comment);
}
