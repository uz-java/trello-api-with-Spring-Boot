package com.example.trelloapiwithspringboot.service.card;

import com.example.trelloapiwithspringboot.dtos.card.CardAddMemberDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:16 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface CardService {
    CardDTO save(CardCreateDTO dto);

    CardDTO addMember(CardAddMemberDTO dto);
}
