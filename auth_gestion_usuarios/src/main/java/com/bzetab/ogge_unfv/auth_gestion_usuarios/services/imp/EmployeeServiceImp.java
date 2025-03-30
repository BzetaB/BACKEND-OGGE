package com.bzetab.ogge_unfv.auth_gestion_usuarios.services.imp;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Employee;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.EmployeeRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.findById(employee.getId_employee())
                .map(emp -> {
                    emp.setName_employee(employee.getName_employee());
                    emp.setLastname_employee(employee.getLastname_employee());
                    emp.setCellphone_employee(employee.getCellphone_employee());
                    emp.setDocument_number(employee.getDocument_number());
                    emp.setDate_departure(employee.getDate_departure());
                    emp.setStatus_employee(employee.getStatus_employee());
                    emp.setDocument(employee.getDocument());
                    return employeeRepository.save(emp);
                }).orElseThrow(() -> new RuntimeException("No se encontro el empleado"));
    }
}
