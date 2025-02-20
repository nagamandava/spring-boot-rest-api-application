package com.nagatechworld.app.service;

import com.nagatechworld.app.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public  EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> GetAllEmployees();
    EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployee);
}
