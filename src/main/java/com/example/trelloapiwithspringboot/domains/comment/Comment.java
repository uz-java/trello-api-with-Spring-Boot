package com.example.trelloapiwithspringboot.domains.comment;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.board.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:05 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE,targetEntity = AuthUser.class)
    @JoinColumn(nullable = false,referencedColumnName = "id",name = "created_by")
    private AuthUser creator;
    @Column(nullable = false)
    private String text;
    private String attachment;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false,name = "card_id",referencedColumnName = "id")
    private Card card;
}
