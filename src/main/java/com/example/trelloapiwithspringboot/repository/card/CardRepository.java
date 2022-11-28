package com.example.trelloapiwithspringboot.repository.card;

import com.example.trelloapiwithspringboot.domains.board.Card;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:58 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface CardRepository extends JpaRepository<Card,Long> {
    @Query("select w from Card c join c.boardColumn t join t.board b join b.workspace w where c.id=:cardId")
    Workspace findWorkspaceByCard(Long cardId);
}
