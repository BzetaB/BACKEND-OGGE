package com.bzetab.ogge_unfv.auth_gestion_usuarios.services;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.UsersAuth;

public interface UserService {
    UsersAuth findById(Integer id);
    String findEmailById(Integer id);
}
