package com.example.trelloapiwithspringboot.validators.base;

import com.example.trelloapiwithspringboot.dtos.base.BaseGenericDTO;
import com.example.trelloapiwithspringboot.dtos.base.GenericDTO;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;

import java.io.Serializable;

/**
 * @author "Tojaliyev Asliddin"
 * @since 13/11/22 00:25 (Sunday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public abstract class AbstractValidator<CD extends BaseGenericDTO,
        UD extends GenericDTO,
        K extends Serializable> implements BaseGenericValidator {
    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD dto) throws ValidationException;

    public abstract void validOnUpdate(UD dto) throws ValidationException;
}
