package com.nagatechworld.app.controller;


import com.nagatechworld.app.dto.EmployeeDto;
import com.nagatechworld.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //build addEmployee RESTAPI
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //bulid Get Employee Rest API(By ID)
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeByID(@PathVariable("id") Long employeeID) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeID);
        return ResponseEntity.ok(employeeDto);
    }
//Build get all Employees RestAPI

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.GetAllEmployees();
        return ResponseEntity.ok(employees);

    }
    //build update Employee RestAPI

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeID, @RequestBody EmployeeDto updatedEmployee ){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeID, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

}
