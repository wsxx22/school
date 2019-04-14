package com.example.school.controller;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeDTO;
import com.example.school.entity.Employee;
import com.example.school.mapper.EmployeeMapper;
import com.example.school.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


    @PostMapping
    public EmployeeDTO addEmployee (@RequestBody @Valid EmployeeCreateDTO employeeCreateDTO) {
        return employeeMapper.employeeToDTO(employeeService.addEmployee(employeeCreateDTO));
    }

}
