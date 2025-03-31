package com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity;

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
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Integer idEmployee;

    @Column(name = "name_employee", nullable = false, length = 80)
    private String nameEmployee;

    @Column(name = "lastname_employee", nullable = false, length = 80)
    private String lastNameEmployee;

    @Column(name = "cellphone_employee", nullable = false, length = 9)
    private String cellphoneEmployee;

    @Column(name = "document_number_employee", nullable = false, length = 15, unique = true)
    private String documentNumberEmployee;

    @Column(name = "date_admission_employee", nullable = false, updatable = false)
    private LocalDateTime dateAdmissionEmployee;

    @Column(name = "date_departure_employee")
    private LocalDateTime dateDepartureEmployee;

    @Column(name = "status_employee", nullable = false)
    private Boolean statusEmployee = false;

    @UpdateTimestamp
    @Column(name = "date_create_modification", nullable = false)
    private LocalDateTime dateCreateModification;

    //RELATIONS
    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    @JsonManagedReference("employee_user")
    private UsersAuth usersAuth;

    @ManyToOne
    @JoinColumn(name = "id_position", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "id_document", nullable = false)
    private Document document;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("employee_steps")
    private Set<EmployeeStep> steps = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("employee_areas")
    private Set<EmployeeArea> areas = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("employee_programs")
    private Set<EmployeeProgram> programs = new HashSet<>();
}
