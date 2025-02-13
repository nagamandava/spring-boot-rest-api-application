package com.nagatechworld.app.mapper;

import com.nagatechworld.app.dto.EmployeeDto;
import com.nagatechworld.app.entity.Employee;

//Mapping Entity to DTO and DTO to Entity to communicate to the client and server
public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(), employeeDto.getEmail());

    }
}
