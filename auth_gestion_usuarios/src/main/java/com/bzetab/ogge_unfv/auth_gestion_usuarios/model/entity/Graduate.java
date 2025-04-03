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
    private Integer idGraduate;

    @Column(name = "name_graduate", nullable = false, length = 80)
    private String nameGraduate;

    @Column(name = "lastname_graduate", nullable = false, length = 80)
    private String lastNameGraduate;

    @Column(name = "document_number_graduate", nullable = false, length = 15, unique = true)
    private String documentNumberGraduate;

    @Column(name = "cellphone_graduate", nullable = false, length = 9)
    private String cellphoneGraduate;

    @Column(name = "current_degree", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrentDegree currentDegree;

    @Column(name = "aspire_degree_graduate", nullable = false)
    @Enumerated(EnumType.STRING)
    private DegreeType aspireDegreeGraduate;

    @Column(name = "status_graduate", nullable = false)
    private Boolean statusGraduate = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    //RELATIONS
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    @JsonManagedReference("graduate_user")
    private UsersAuth usersAuth;

    @ManyToOne
    @JoinColumn(name = "id_document", nullable = false)
    private Document document;

    @OneToMany(mappedBy = "graduate", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<GraduateDegree> degrees = new HashSet<>();
}
