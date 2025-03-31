package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "POSITION")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_position")
    private Integer idPosition;

    @Column(name = "name_position", nullable = false, length = 80, unique = true)
    private String namePosition;

    @Column(name = "description_position", length = 100)
    private String descriptionPosition;
}
