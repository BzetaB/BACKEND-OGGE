package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_STEP")
public class EmployeeStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee_step")
    private Integer id_employee_step;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    @JsonBackReference("employee_steps")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_step", nullable = false)
    @JsonBackReference("step_employees")
    private Step step;
}
