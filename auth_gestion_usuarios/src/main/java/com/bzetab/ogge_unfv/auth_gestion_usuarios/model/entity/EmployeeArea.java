package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE_AREA")
public class EmployeeArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee_area")
    private Integer idEmployeeArea;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    @JsonBackReference("employee_areas")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    @JsonBackReference("area_employees")
    private Area area;
}
