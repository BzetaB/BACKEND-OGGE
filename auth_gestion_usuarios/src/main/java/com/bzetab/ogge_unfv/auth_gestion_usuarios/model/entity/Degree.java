package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.enums.DegreeType;
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
@Table(name = "DEGREE")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_degree")
    private Integer idDegree;

    @Column(name = "degree_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DegreeType degreeType;

    @Column(name = "name_degree", nullable = false, length = 80, unique = true)
    private String nameDegree;

    @Column(name = "status_degree", nullable = false)
    private Boolean statusDegree = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    @OneToMany(mappedBy = "degree", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<GraduateDegree> graduates = new HashSet<>();
}
