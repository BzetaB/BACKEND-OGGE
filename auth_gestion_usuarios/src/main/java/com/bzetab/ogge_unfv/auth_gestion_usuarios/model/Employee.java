package com.bzetab.ogge_unfv.auth_gestion_usuarios.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer id_employee;

    @Column(name = "name_employee", nullable = false, length = 80)
    private String name_employee;

    @Column(name = "lastname_employee", nullable = false, length = 80)
    private String lastname_employee;

    @Column(name = "cellphone_employee", nullable = false, length = 9)
    private String cellphone_employee;

    @Column(name = "document_number", nullable = false, length = 15, unique = true)
    private String document_number;

    @CreationTimestamp
    @Column(name = "date_admission", nullable = false, updatable = false)
    private LocalDateTime date_admission;

    @Column(name = "date_departure")
    private LocalDateTime date_departure;

    @Column(name = "status_employee", nullable = false)
    private Boolean status_employee = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime date_create_modification;
}
