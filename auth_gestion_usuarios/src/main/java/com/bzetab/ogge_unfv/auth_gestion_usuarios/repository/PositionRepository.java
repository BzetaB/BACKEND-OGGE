package com.bzetab.ogge_unfv.auth_gestion_usuarios.repository;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
