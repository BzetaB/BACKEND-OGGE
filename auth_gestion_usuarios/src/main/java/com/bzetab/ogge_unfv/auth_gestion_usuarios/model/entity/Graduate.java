package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "GRADUATE")
public class Graduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_graduate")
    private Integer id_graduate;

    @Column(name = "name_graduate", nullable = false, length = 80)
    private String name_graduate;

    @Column(name = "lastname_graduate", nullable = false, length = 80)
    private String lastname_graduate;

    @Column(name = "document_number", nullable = false, length = 15, unique = true)
    private String document_number;

    @Column(name = "cellphone_employee", nullable = false, length = 9)
    private String cellphone_graduate;

    @Column(name = "aspire_degree_graduate", nullable = false)
    private Boolean aspire_degree_graduate;

    @Column(name = "status_employee", nullable = false)
    private Boolean status_graduate = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime date_create_modification;
}
