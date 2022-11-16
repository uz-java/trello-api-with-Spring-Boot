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
public class CommentCreateDTO {
    private String creatorEmail;
    private String text;
    private String attachment;
    private Long cardId;
}
