package com.example.hps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.hps.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
	@Query(value = "SELECT r.* FROM role r INNER JOIN utilisateur u on(r.id_role=u.role) WHERE u.idutilisateur= :idutilisateur ",nativeQuery = true)
	Role getrolebyuser(@Param("idutilisateur") Long idutilisateur);
}
