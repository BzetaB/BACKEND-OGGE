package com.bzetab.ogge_unfv.auth_gestion_usuarios.controller;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.UsersAuth;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gestion-usuarios/usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/buscar/{id}")
    public ResponseEntity<UsersAuth> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }
    @GetMapping("/email-usuario/{id}")
    public ResponseEntity<String> getEmailUsersByID(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findEmailById(id));
    }
}
