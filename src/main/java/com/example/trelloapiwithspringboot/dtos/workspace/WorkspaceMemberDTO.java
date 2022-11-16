package com.example.trelloapiwithspringboot.dtos.workspace;

import lombok.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 14:05 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkspaceMemberDTO {
    private Long id;
    private String memberEmail;
}
