package com.example.trelloapiwithspringboot.repository.workspaceRepository;

import com.example.trelloapiwithspringboot.domains.auth.AuthUser;
import com.example.trelloapiwithspringboot.domains.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 23:58 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
public interface WorkspaceRepository extends JpaRepository<Workspace,Long> {
    @Query(value = "select t from Workspace t where (t.createdBy =:user or :user member of t.members) and t.isDeleted=false")
    List<Workspace> findAllByUser(AuthUser user);
}
