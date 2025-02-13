package com.nagatechworld.app.service.impl;

import com.nagatechworld.app.dto.EmployeeDto;
import com.nagatechworld.app.entity.Employee;
import com.nagatechworld.app.mapper.EmployeeMapper;
import com.nagatechworld.app.repository.EmployeeRepository;
import com.nagatechworld.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
       return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        return null;
    }
}
