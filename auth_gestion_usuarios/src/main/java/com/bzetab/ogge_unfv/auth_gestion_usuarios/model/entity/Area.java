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
@Table(name = "AREA")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer idArea;

    @Column(name = "name_area", nullable = false, length = 80, unique = true)
    private String nameArea;

    @Column(name = "status_area", nullable = false)
    private Boolean statusArea = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("area_employees")
    private Set<EmployeeArea> employees = new HashSet<>();
}
