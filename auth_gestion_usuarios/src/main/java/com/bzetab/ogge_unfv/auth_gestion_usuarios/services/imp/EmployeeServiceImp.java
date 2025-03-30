package com.bzetab.ogge_unfv.auth_gestion_usuarios.services.imp;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.dto.EmployeeDto;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Document;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Employee;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Position;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.UsersAuth;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.DocumentRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.EmployeeRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.PositionRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.repository.UserAuthRepository;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final DocumentRepository documentRepository;

    public EmployeeServiceImp(
            EmployeeRepository employeeRepository,
            UserAuthRepository usersAuthRepository,
            PositionRepository positionRepository,
            DocumentRepository documentRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.documentRepository = documentRepository;
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
    public Employee updateEmployee(EmployeeDto employeeDto) {
        return employeeRepository.findById(employeeDto.getId_employee())
                .map(emp -> {
                    emp.setName_employee(employeeDto.getName_employee());
                    emp.setLastname_employee(employeeDto.getLast_name_employee());
                    emp.setCellphone_employee(employeeDto.getCellphone_employee());

                    if (employeeDto.getId_document() != null) {
                        Document document = documentRepository.findById(employeeDto.getId_document()).orElse(null);
                        emp.setDocument(document);
                    }
                    emp.setDocument_number(employeeDto.getDocument_number_employee());
                    emp.setDate_departure(employeeDto.getDate_departure_employee());
                    emp.setStatus_employee(employeeDto.getStatus_employee());


                    if (employeeDto.getId_position() != null) {
                        Position position = positionRepository.findById(employeeDto.getId_position()).orElse(null);
                        emp.setPosition(position);
                    }

                    UsersAuth usersAuth = emp.getUsersAuth();
                    if (usersAuth != null) {
                        usersAuth.setEmail_users(employeeDto.getEmail_employee());
                        usersAuth.setPassword_users(employeeDto.getPassword());
                        emp.setUsersAuth(usersAuth);
                    }

                    return employeeRepository.save(emp);
                }).orElseThrow(() -> new RuntimeException("No se encontro el empleado"));
    }
}
