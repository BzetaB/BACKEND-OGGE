package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTResponse {
    String token;
}
