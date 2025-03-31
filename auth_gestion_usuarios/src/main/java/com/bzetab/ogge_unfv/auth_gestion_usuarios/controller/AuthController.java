package com.bzetab.ogge_unfv.auth_gestion_usuarios.controller;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.request.LoginRequest;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.request.RegisterRequest;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.response.JWTResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(new JWTResponse());
    }

    @PostMapping("/signUp")
    public ResponseEntity<JWTResponse> signUp(@RequestBody RegisterRequest registerRequest) {
        return ResponseEntity.ok(new JWTResponse());
    }
}
