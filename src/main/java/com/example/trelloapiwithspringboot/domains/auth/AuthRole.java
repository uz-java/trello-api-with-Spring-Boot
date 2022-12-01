package com.example.trelloapiwithspringboot.domains.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 13:00 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AuthRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String code;
/*    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "role_perm",
    joinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "per_id",referencedColumnName = "id"))
    private Set<AuthPermission> permissions;*/
    @Override
    public String getAuthority() {
        return "ROLE_"+this.code;
    }
}
