package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EmployeeDto {
    private Integer id_employee;
    private String name_employee;
    private String last_name_employee;
    private String cellphone_employee;
    private Integer id_document;
    private String document_number_employee;
    private LocalDateTime date_departure_employee;
    private Boolean status_employee;
    private Integer id_position;
    private String email_employee;
    private String password;
}
