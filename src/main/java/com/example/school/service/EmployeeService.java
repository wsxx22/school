package com.example.school.service;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.entity.Employee;
import com.example.school.mapper.EmployeeMapper;
import com.example.school.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public Employee addEmployee(EmployeeCreateDTO employeeCreateDTO) {
        return employeeRepository.save(employeeMapper.employeeDTOToEmployeeEntity(employeeCreateDTO));
    }
}
