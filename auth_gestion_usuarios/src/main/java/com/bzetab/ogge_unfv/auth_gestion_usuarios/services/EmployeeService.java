package com.bzetab.ogge_unfv.auth_gestion_usuarios.services;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.dto.EmployeeDto;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    Employee registerEmployee(Employee employee);
    Employee updateEmployee(EmployeeDto employeeDto);
}
