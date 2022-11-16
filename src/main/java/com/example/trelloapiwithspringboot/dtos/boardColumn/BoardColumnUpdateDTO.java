package com.example.trelloapiwithspringboot.dtos.boardColumn;

import com.example.trelloapiwithspringboot.dtos.base.GenericDTO;
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
public class BoardColumnUpdateDTO extends GenericDTO {
    private Long id;
    private String name;
    private Long order;
    private Long boardId;
}
