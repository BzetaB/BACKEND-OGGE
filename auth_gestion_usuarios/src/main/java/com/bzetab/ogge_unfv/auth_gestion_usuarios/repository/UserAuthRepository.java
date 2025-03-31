package com.bzetab.ogge_unfv.auth_gestion_usuarios.repository;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.UsersAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UsersAuth, Integer> {
    Optional<UsersAuth> findByEmailUsers(String emailUsers);
}
