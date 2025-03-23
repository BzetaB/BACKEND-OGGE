package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "AREA")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer id_area;

    @Column(name = "name_area", nullable = false, length = 80, unique = true)
    private String name_area;

    @Column(name = "status_area", nullable = false)
    private Boolean status_area = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime date_create_modification;
}
