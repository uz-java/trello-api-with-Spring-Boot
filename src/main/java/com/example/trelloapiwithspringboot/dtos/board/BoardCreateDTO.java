package com.example.trelloapiwithspringboot.dtos.board;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;
import com.example.trelloapiwithspringboot.enums.board.BoardVisibilityType;
import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:25 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BoardCreateDTO implements BaseGenericDTO {
    private String name;
    @Builder.Default
    private BoardVisibilityType visibilityType=BoardVisibilityType.PUBLIC;
    private Long workspaceId;
}
