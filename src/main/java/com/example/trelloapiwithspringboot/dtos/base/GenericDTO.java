package com.example.trelloapiwithspringboot.dtos.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:22 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenericDTO implements BaseGenericDTO{
    private Long id;
}
