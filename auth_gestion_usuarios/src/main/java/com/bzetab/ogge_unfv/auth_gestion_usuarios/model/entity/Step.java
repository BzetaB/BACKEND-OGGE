package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "STEP")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_step")
    private Integer idStep;

    @Column(name = "name_step", nullable = false, length = 80, unique = true)
    private String nameStep;

    @Column(name = "status_step", nullable = false)
    private Boolean statusStep = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("step_employees")
    private Set<EmployeeStep> employees = new HashSet<>();
}
