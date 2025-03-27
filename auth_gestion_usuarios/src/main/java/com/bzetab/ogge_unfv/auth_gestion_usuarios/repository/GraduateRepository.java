package com.bzetab.ogge_unfv.auth_gestion_usuarios.repository;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateRepository extends JpaRepository<Graduate, Integer> {
}
