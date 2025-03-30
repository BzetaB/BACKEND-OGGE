package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.enums.CurrentDegree;
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

    @Column(name = "current_degree", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrentDegree current_degree;

    @Column(name = "aspire_degree_graduate", nullable = false)
    @Enumerated(EnumType.STRING)
    private DegreeType aspire_degree_graduate;

    @Column(name = "status_employee", nullable = false)
    private Boolean status_graduate = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime date_create_modification;

    //RELATIONS
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_users", nullable = false)
    private UsersAuth usersAuth;

    @ManyToOne
    @JoinColumn(name = "id_document", nullable = false)
    private Document document;

    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<GraduateDegree> degrees = new HashSet<>();
}
