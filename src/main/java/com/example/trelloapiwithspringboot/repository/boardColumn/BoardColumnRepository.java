package com.example.trelloapiwithspringboot.repository.boardColumn;

import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:57 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface BoardColumnRepository extends JpaRepository<BoardColumn,Long> {
}
