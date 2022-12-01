package com.example.trelloapiwithspringboot.dtos.card;

import com.example.trelloapiwithspringboot.dtos.auth.UserDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentDTO;
import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:35 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardDTO {
    private Long id;
    private String name;
    private Set<UserDTO> members;
    private Long boardColumnId;
    private List<CommentDTO> comments;
}
