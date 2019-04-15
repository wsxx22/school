package com.example.school.service;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeShowDTO;
import com.example.school.mapper.EmployeeMapper;
import com.example.school.repository.EmployeeRepository;
import com.example.school.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    public EmployeeShowDTO addEmployee(EmployeeCreateDTO employeeCreateDTO) {
        return employeeMapper.employeeToDTO(
                employeeRepository.save(
                        employeeMapper.employeeDTOToEmployeeEntity(employeeCreateDTO)));
    }

    public List<EmployeeShowDTO> findAll (EmployeeSpecification spec, Pageable pageable) {
        return employeeMapper.employeeToDTOPage(employeeRepository.findAll(spec, pageable).getContent());
    }
}
