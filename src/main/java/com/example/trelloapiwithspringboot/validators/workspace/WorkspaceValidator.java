package com.example.trelloapiwithspringboot.validators.workspace;

import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceCreateDTO;
import com.example.trelloapiwithspringboot.dtos.workspace.WorkspaceUpdateDTO;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.repository.auth.UserRepository;
import com.example.trelloapiwithspringboot.repository.workspaceRepository.WorkspaceRepository;
import com.example.trelloapiwithspringboot.validators.base.AbstractValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:29 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Component
@RequiredArgsConstructor
public class WorkspaceValidator extends AbstractValidator<WorkspaceCreateDTO, WorkspaceUpdateDTO,Long> {
    private final UserRepository userRepository;
    private final WorkspaceRepository workspaceRepository;

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(WorkspaceCreateDTO dto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(WorkspaceUpdateDTO dto) throws ValidationException {

    }
}
