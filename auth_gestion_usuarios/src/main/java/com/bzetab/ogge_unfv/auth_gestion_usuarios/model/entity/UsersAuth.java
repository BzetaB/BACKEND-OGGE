package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer idUsers;

    @Column(name = "email_users", nullable = false, length = 100, unique = true)
    private String emailUsers;

    @Column(name = "password_users", nullable = false, length = 50)
    private String passwordUsers;

    @Column(name = "status_users", nullable = false)
    private Boolean statusUsers = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    //RELATIONS
    @OneToOne(mappedBy = "usersAuth", cascade = CascadeType.ALL)
    @JsonBackReference("employee_user")
    private Employee employee;

    @OneToOne(mappedBy = "usersAuth", cascade = CascadeType.ALL)
    @JsonBackReference("graduate_user")
    private Graduate graduate;
}
