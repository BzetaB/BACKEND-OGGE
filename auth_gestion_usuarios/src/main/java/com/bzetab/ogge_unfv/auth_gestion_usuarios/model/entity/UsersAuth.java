package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "USERS_AUTH")
public class UsersAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private Integer id_users;

    @Column(name = "email_users", nullable = false, length = 100, unique = true)
    private String email_users;

    @Column(name = "password_users", nullable = false, length = 50)
    private String password_users;

    @Column(name = "status_users", nullable = false)
    private Boolean status_users = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime date_create_modification;

    //RELATIONS
    @OneToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id_rol", nullable = false)
    private Rol rol;
}
