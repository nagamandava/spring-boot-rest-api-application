package com.nagatechworld.app.service.impl;

import com.nagatechworld.app.dto.EmployeeDto;
import com.nagatechworld.app.entity.Employee;
import com.nagatechworld.app.exception.ResourceNotFoundException;
import com.nagatechworld.app.mapper.EmployeeMapper;
import com.nagatechworld.app.repository.EmployeeRepository;
import com.nagatechworld.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(" employee is not exsits with given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> GetAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeID, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(() -> new ResourceNotFoundException("employee is not exist with given id: " + employeeID));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedEmployeeObject = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObject);
    }

    @Override
    public void deleteEmployee(Long employeeID) {

        Employee employee = employeeRepository.findById(employeeID).orElseThrow(
                () -> new ResourceNotFoundException("employee is not exist with given id: " + employeeID));

        employeeRepository.deleteById(employeeID);
    }
}
