package com.example.trelloapiwithspringboot.validators.card;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.board.Board;
import com.example.trelloapiwithspringboot.domains.board.BoardColumn;
import com.example.trelloapiwithspringboot.domains.board.Card;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.dtos.card.CardAddMemberDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardChangeColumnDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardUpdateDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentCreateDTO;
import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.card.CardRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import com.example.trelloapiwithspringboot.validators.board.BoardColumnValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:28 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class CardValidator extends AbstractValidator<CardCreateDTO, CardUpdateDTO,Long> {

    private final BoardColumnValidator boardColumnValidator;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {
        Card card = getCard(id);
        boardColumnValidator.validateKey(card.getBoardColumn().getId());
    }

    @Override
    public void validOnCreate(CardCreateDTO dto) throws ValidationException {
        boardColumnValidator.validateKey(dto.getBoardColumnId());
        String name = dto.getName();
        if (Objects.isNull(name) || name.isBlank())
            throw new ValidationException("Name can not be empty");
    }

    @Override
    public void validOnUpdate(CardUpdateDTO dto) throws ValidationException {

    }

    private Card getCard(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new GenericNotFoundException("Card not found by id: %s".formatted(id)));
        if (card.getIsDeleted())
            throw new ValidationException("Card is not available with id: %s".formatted(id));
        return card;
    }

    public void validateOnAddMember(CardAddMemberDTO dto) {
        validateKey(dto.getId());
        AuthUser user = userRepository.findByEmail(dto.getMemberEmail())
                .orElseThrow(() -> new GenericNotFoundException("user not found by email: " + dto.getMemberEmail()));
        Workspace workspaceByCard = cardRepository.findWorkspaceByCard(dto.getId());
        if (!workspaceByCard.getMembers().contains(user))
            throw new ValidationException("You can't add member outside your workspace");
    }

    public void validateOnAddComment(CommentCreateDTO dto) {
        validateKey(dto.getCardId());
        String text = dto.getText();
        if (Objects.isNull(text) || text.isBlank())
            throw new ValidationException(
                    "Comment text can not be empty");
    }
    public void validateOnChangeColumn(CardChangeColumnDTO dto) {
        validateKey(dto.getId());
        Card card = getCard(dto.getId());
        Board board = card.getBoardColumn().getBoard();
        Long boardColumnId = dto.getBoardColumnId();
        BoardColumn boardColumn = boardColumnValidator.getBoardColumn(boardColumnId);
        boolean isColumnFromSameBoard = board.getBoardColumns().contains(boardColumn);
        if (!isColumnFromSameBoard) {
            throw new ValidationException(
                    "Board not contains column with id: " + boardColumnId);
        }
    }
    public void validateOnDelete(Long id) {
        Card card = getCard(id);
        boardColumnValidator.validateOnDelete(card.getBoardColumn().getId());
    }
}
