package com.example.school.mapper;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeShowDTO;
import com.example.school.entity.Employee;
import com.example.school.service.ProfessionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Autowired
    private ProfessionService professionService;

    @Mappings({
            @Mapping(target = "profession", source = "profession.name")
    })
    public abstract EmployeeShowDTO employeeToDTO(Employee employee);

    public abstract List<EmployeeShowDTO> employeeToDTOPage(List<Employee> employees);

    public Employee employeeDTOToEmployeeEntity(EmployeeCreateDTO employeeCreateDTO) {

        if (employeeCreateDTO == null) {
            return null;
        }

        return new Employee(
                employeeCreateDTO.getName(),
                employeeCreateDTO.getSurname(),
                employeeCreateDTO.getUsername(),
                employeeCreateDTO.getPassword(),
                employeeCreateDTO.getAge(),
                professionService.findById(employeeCreateDTO.getProfession())
        );

    }

}