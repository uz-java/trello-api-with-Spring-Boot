package com.example.trelloapiwithspringboot.repository.card;

import com.example.trelloapiwithspringboot.domains.board.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:58 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface CardRepository extends JpaRepository<Card,Long> {

}
