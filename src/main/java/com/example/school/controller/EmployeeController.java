package com.example.school.controller;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeShowDTO;
import com.example.school.service.EmployeeService;
import com.example.school.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    public EmployeeShowDTO addEmployee (@RequestBody @Valid EmployeeCreateDTO employeeCreateDTO) {
        return employeeService.addEmployee(employeeCreateDTO);
//        return employeeMapper.employeeToDTO(employeeService.addEmployee(employeeCreateDTO));
    }

    @GetMapping
    public List<EmployeeShowDTO> findAll (EmployeeSpecification spec, @PageableDefault(size = 5) Pageable pageable) {
        return employeeService.findAll(spec, pageable);
    }

}
