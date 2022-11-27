package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.card.CardAddMemberDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardChangeColumnDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.card.CardDTO;
import com.example.trelloapiwithspringboot.dtos.comment.CommentCreateDTO;
import com.example.trelloapiwithspringboot.service.card.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CardDTO> createBoardColumn(@RequestBody CardCreateDTO dto) {
        CardDTO cardDTO = cardService.save(dto);
        return new ResponseEntity<>(cardDTO, HttpStatus.CREATED);
    }

    @PostMapping("/addMember")
    public ResponseEntity<CardDTO> addMember(@RequestBody CardAddMemberDTO dto) {
        CardDTO cardDTO = cardService.addMember(dto);
        return new ResponseEntity<>(cardDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/comment/create")
    public ResponseEntity<CardDTO> addCommend(@RequestBody CommentCreateDTO dto){
        CardDTO cardDTO=cardService.addComment(dto);
        return new ResponseEntity<>(cardDTO,HttpStatus.OK);
    }

    @PatchMapping(value = "/changeColumn")
    public ResponseEntity<CardDTO> changeColumn(@RequestBody CardChangeColumnDTO dto){
        CardDTO cardDTO=cardService.changeColumn(dto);
        return new ResponseEntity<>(cardDTO,HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id){
        return new ResponseEntity<>(cardService.deleteCard(id),HttpStatus.NO_CONTENT);
    }
}