package com.bzetab.ogge_unfv.auth_gestion_usuarios.controller;

import com.bzetab.ogge_unfv.auth_gestion_usuarios.model.entity.Employee;
import com.bzetab.ogge_unfv.auth_gestion_usuarios.services.imp.EmployeeServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestion-usuarios/employee")
public class EmployeeController {

    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employee = employeeServiceImp.updateEmployee(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> employeeList(){
        return ResponseEntity.ok(employeeServiceImp.getEmployees());
    }
}
