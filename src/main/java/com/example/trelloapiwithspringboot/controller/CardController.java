package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import com.example.trelloapiwithspringboot.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Tojaliyev Asliddin"
 * @since 26/11/22 00:43 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
@PreAuthorize("isAuthenticated()")
public class CardController {
    private final CardService cardService;

    @PostMapping(value = "/create",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CardDTO> createBoardColumn(@RequestBody CardCreateDTO dto){
        CardDTO cardDTO=cardService.save(dto);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }

}
