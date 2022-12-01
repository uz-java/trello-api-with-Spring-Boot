package com.example.trelloapiwithspringboot.dtos.board;

import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;
import com.example.trelloapiwithspringboot.enums.board.BoardVisibilityType;
import lombok.*;

import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:25 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private Long id;
    private String name;
    private BoardVisibilityType visibilityType;
    private Long workspaceId;
    private Set<BoardColumnDTO> boardColumns;
}
