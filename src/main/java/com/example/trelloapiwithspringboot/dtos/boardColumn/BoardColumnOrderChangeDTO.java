package com.example.trelloapiwithspringboot.dtos.boardColumn;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:32 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardColumnOrderChangeDTO {
    private Long id;
    private Long order;
}
