package com.nagatechworld.app.service;

import com.nagatechworld.app.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public  EmployeeDto getEmployeeById(Long employeeId);
}
