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
        return employeeRepository.findById(employeeDto.getIdEmployee())
                .map(emp -> {
                    emp.setNameEmployee(employeeDto.getNameEmployee());
                    emp.setLastNameEmployee(employeeDto.getLastNameEmployee());
                    emp.setCellphoneEmployee(employeeDto.getCellphoneEmployee());

                    if (employeeDto.getIdDocumentEmployee() != null) {
                        Document document = documentRepository.findById(employeeDto.getIdDocumentEmployee()).orElse(null);
                        emp.setDocument(document);
                    }
                    emp.setDocumentNumberEmployee(employeeDto.getDocumentNumberEmployee());
                    emp.setDateDepartureEmployee(employeeDto.getDateDepartureEmployee());
                    emp.setStatusEmployee(employeeDto.getStatusEmployee());


                    if (employeeDto.getIdPositionEmployee() != null) {
                        Position position = positionRepository.findById(employeeDto.getIdPositionEmployee()).orElse(null);
                        emp.setPosition(position);
                    }

                    UsersAuth usersAuth = emp.getUsersAuth();
                    if (usersAuth != null) {
                        usersAuth.setEmailUsers(employeeDto.getEmailEmployee());
                        usersAuth.setPasswordUsers(employeeDto.getPasswordEmployee());
                        emp.setUsersAuth(usersAuth);
                    }

                    return employeeRepository.save(emp);
                }).orElseThrow(() -> new RuntimeException("No se encontro el empleado"));
    }
}
