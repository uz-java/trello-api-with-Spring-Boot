package com.example.trelloapiwithspringboot.repository.board;

import com.example.trelloapiwithspringboot.domains.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:57 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface BoardRepository extends JpaRepository<Board,Long> {
}
