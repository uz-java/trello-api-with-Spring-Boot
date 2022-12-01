package com.example.trelloapiwithspringboot.dtos.boardColumn;

import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import lombok.*;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:31 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardColumnDTO {
    private Long id;
    private String name;
    private Long order;
    private Long boardId;
    private List<CardDTO> cardSet;
}
