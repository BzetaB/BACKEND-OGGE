package com.bzetab.ogge_unfv.auth_gestion_usuarios.repository;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
