package com.example.trelloapiwithspringboot.dtos.card;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:34 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardChangeColumnDTO {
    private Long id;
    private Long boardColumnId;
}
