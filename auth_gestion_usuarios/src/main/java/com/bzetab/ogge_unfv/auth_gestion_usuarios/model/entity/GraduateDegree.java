package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "GRADUATE_DEGREE")
public class GraduateDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_graduate_degree")
    private Integer idGraduateDegree;

    @ManyToOne
    @JoinColumn(name = "id_graduate", nullable = false)
    @JsonBackReference
    private Graduate graduate;

    @ManyToOne
    @JoinColumn(name = "id_degree", nullable = false)
    @JsonBackReference
    private Degree degree;
}
