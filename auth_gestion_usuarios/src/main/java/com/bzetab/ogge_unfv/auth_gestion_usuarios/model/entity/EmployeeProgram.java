package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_PROGRAM")
public class EmployeeProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee_program")
    private Integer idEmployeeProgram;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    @JsonBackReference("employee_programs")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_program", nullable = false)
    @JsonBackReference("program_employees")
    private Program program;
}
