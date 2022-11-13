package com.example.trelloapiwithspringboot.validators.card;

import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardUpdateDTO;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.card.CardRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import com.example.trelloapiwithspringboot.validators.board.BoardColumnValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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

    }

    @Override
    public void validOnCreate(CardCreateDTO dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CardUpdateDTO dto) throws ValidationException {

    }
}
