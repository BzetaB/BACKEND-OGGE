package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.request;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nameUser;
    private String lastNameUser;
    private Integer idDocument;
    private String documentNumber;
    private String cellphoneUser;
    private String emailUser;
    private String passwordUser;
}
