package com.example.trelloapiwithspringboot.service.card;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import com.example.trelloapiwithspringboot.domains.board.Card;
import com.example.trelloapiwithspringboot.domains.comment.Comment;
import com.example.trelloapiwithspringboot.dtos.card.CardAddMemberDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardChangeColumnDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentCreateDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.mappers.card.CardMapper;
import com.example.trelloapiwithspringboot.mappers.comment.CommentMapper;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.boardColumn.BoardColumnRepository;
import com.example.trelloapiwithspringboot.repository.card.CardRepository;
import com.example.trelloapiwithspringboot.validators.card.CardValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:17 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Service
@Transactional
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final CardValidator cardValidator;
    private final CardMapper cardMapper;
    private final BoardColumnRepository boardColumnRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;
    @Override
    public CardDTO save(CardCreateDTO dto) {
        cardValidator.validOnCreate(dto);
        Card card = cardMapper.fromCreateDTO(dto);
        BoardColumn boardColumn = boardColumnRepository.findById(dto.getBoardColumnId())
                .orElseThrow(() -> new GenericNotFoundException("Board column not found by id: " + dto.getBoardColumnId()));
        card.setBoardColumn(boardColumn);
        return cardMapper.fromCard(cardRepository.save(card));
    }

    @Override
    public CardDTO addMember(CardAddMemberDTO dto) {
        cardValidator.validateOnAddMember(dto);
        Card card = getCard(dto.getId());
        AuthUser authUser = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("user not found by email: " + dto.getMemberEmail()));
        card.getMembers().add(authUser);
        return cardMapper.fromCard(cardRepository.save(card));
    }

    @Override
    public CardDTO addComment(CommentCreateDTO dto) {
        cardValidator.validateOnAddComment(dto);
        Comment comment = commentMapper.fromCreateDTO(dto);
        AuthUser authUser = userRepository.findByEmail(dto.getCreatorEmail())
                .orElseThrow(() -> new GenericNotFoundException("User not found by email: " + dto.getCreatorEmail()));
        comment.setCreator(authUser);
        Long cardId = dto.getCardId();
        Card card = getCard(cardId);
        comment.setCard(card);
        card.getComments().add(comment);
        return cardMapper.fromCard(cardRepository.save(card));
    }

    @Override
    public CardDTO changeColumn(CardChangeColumnDTO dto) {
        cardValidator.validateOnChangeColumn(dto);
        Card card = getCard(dto.getId());
        BoardColumn boardColumn = boardColumnRepository.findById(dto.getBoardColumnId())
                .orElseThrow(() -> new GenericNotFoundException("Board column not found by id: " + dto.getBoardColumnId()));
        card.setBoardColumn(boardColumn);
        return cardMapper.fromCard(cardRepository.save(card));
    }

    @Override
    public void deleteCard(Long id) {
        cardValidator.validateOnDelete(id);
        Card card = getCard(id);
        card.setIsDeleted(true);
        cardRepository.save(card);
    }

    private Card getCard(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new GenericNotFoundException("Card not found by id: " + cardId));
        return card;
    }
}
