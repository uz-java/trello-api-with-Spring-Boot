package com.example.trelloapiwithspringboot.dtos.card;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;
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
public class CardCreateDTO implements BaseGenericDTO {
    private String name;
    private Long boardColumnId;
}
