package com.example.trelloapiwithspringboot.controller;

import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceDTO;
import com.example.trelloapiwithspringboot.service.workspace.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author "Tojaliyev Asliddin"
 * @since 26/11/22 00:44 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/workspace")
@PreAuthorize("isAuthenticated()")
public class WorkspaceController {
    private final WorkspaceService workspaceService;

    @PostMapping(value = "/create",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WorkspaceDTO> createWorkspaceDTO(@Valid @RequestBody WorkspaceCreateDTO dto){
        WorkspaceDTO workspaceDTO=workspaceService.save(dto);
        return new ResponseEntity<>(workspaceDTO, HttpStatus.CREATED);
    }
}
