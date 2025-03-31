package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ROL_USERS")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "name_rol", nullable = false, length = 100, unique = true)
    private String nameRol;

    @Column(name = "status_rol", nullable = false)
    private Boolean statusRol = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;
}
