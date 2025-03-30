package com.bzetab.ogge_unfv.auth_gestion_usuarios.repository;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
