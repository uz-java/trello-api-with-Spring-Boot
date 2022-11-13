package com.example.trelloapiwithspringboot.repository.workspaceRepository;

import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:58 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface WorkspaceRepository extends JpaRepository<Workspace,Long> {

}
