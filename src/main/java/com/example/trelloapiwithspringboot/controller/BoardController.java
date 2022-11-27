package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.board.BoardCreateDTO;
import com.example.trelloapiwithspringboot.dtos.board.BoardDTO;
import com.example.trelloapiwithspringboot.service.board.BoardService;
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
@RequestMapping("/board")
@PreAuthorize("isAuthenticated()")
public class BoardController {
    private final BoardService boardService;

    @PostMapping(value = "/create",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardCreateDTO dto){
        BoardDTO boardDTO=boardService.save(dto);
        return new ResponseEntity<>(boardDTO, HttpStatus.CREATED);
    }

}
