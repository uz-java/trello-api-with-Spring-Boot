package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnCreateDTO;
import com.example.trelloapiwithspringboot.dtos.boardColumn.BoardColumnDTO;
import com.example.trelloapiwithspringboot.service.boardColumn.BoardColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/boardColumn")
@RequiredArgsConstructor
public class BoardColumnController {
    private final BoardColumnService boardColumnService;

    @PostMapping(value = "/create",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardColumnDTO> createBoardColumn(@RequestBody BoardColumnCreateDTO dto) {
        BoardColumnDTO boardColumnDTO = boardColumnService.save(dto);
        return new ResponseEntity<>(boardColumnDTO, HttpStatus.CREATED);
    }


}
