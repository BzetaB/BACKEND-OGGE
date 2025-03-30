package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PROGRAM")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_program")
    private Integer id_program;

    @Column(name = "name_program", nullable = false, length = 80, unique = true)
    private String name_program;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("program_employees")
    private Set<EmployeeProgram> employees = new HashSet<>();
}
