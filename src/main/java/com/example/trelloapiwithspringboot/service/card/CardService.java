package com.example.trelloapiwithspringboot.service.card;

import com.example.trelloapiwithspringboot.dtos.card.CardAddMemberDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardChangeColumnDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentCreateDTO;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:16 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
public interface CardService {
    CardDTO save(CardCreateDTO dto);

    CardDTO addMember(CardAddMemberDTO dto);

    CardDTO addComment(CommentCreateDTO dto);

    CardDTO changeColumn(CardChangeColumnDTO dto);

    void deleteCard(Long id);
}
