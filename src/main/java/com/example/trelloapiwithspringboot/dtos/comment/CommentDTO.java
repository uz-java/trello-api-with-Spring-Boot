package com.example.trelloapiwithspringboot.dtos.comment;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:38 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {
    private Long id;
    private String creator;
    private String text;
    private String attachment;
    private Long cardId;
}
