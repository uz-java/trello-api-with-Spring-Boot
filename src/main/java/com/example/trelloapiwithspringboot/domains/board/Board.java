package com.example.trelloapiwithspringboot.domains.board;

import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import com.example.trelloapiwithspringboot.enums.board.BoardVisibilityType;
import lombok.*;
import org.glassfish.hk2.api.Visibility;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:01 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private BoardVisibilityType visibilityType;

    @Builder.Default
    @OneToMany(mappedBy = "board")
    private Set<BoardColumn> boardColumns=new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workspace_id",nullable = false,referencedColumnName = "id")
    private Workspace workspace;

    @Builder.Default
    @Column(columnDefinition = "bool default false")
    private Boolean isDeleted=false;
}
