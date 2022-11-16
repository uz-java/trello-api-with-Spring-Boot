package com.example.trelloapiwithspringboot.dtos.boardColumn;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;
import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:30 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BoardColumnCreateDTO implements BaseGenericDTO {
    private String name;
    private Long order;
    private Long boardId;
}
