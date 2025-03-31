package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeDto {
    private Integer idEmployee;
    private String nameEmployee;
    private String lastNameEmployee;
    private String cellphoneEmployee;
    private Integer idDocumentEmployee;
    private String documentNumberEmployee;
    private LocalDateTime dateDepartureEmployee;
    private Boolean statusEmployee;
    private Integer idPositionEmployee;
    private String emailEmployee;
    private String passwordEmployee;
}
