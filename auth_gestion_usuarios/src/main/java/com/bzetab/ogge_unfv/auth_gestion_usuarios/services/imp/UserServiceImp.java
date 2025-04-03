package com.bzetab.ogge_unfv.auth_gestion_usuarios.services.imp;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.UsersAuth;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.UserAuthRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private final UserAuthRepository userAuthRepository;

    public UserServiceImp(UserAuthRepository userAuthRepository) {
        this.userAuthRepository = userAuthRepository;
    }

    @Override
    public UsersAuth findById(Integer id) {
        return userAuthRepository.findById(id).orElse(null);
    }

    @Override
    public String findEmailById(Integer id) {
        UsersAuth usersAuth = this.findById(id);
        return usersAuth.getEmailUsers();
    }
}
