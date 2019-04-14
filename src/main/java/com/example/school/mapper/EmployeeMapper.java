package com.example.school.mapper;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeDTO;
import com.example.school.entity.Employee;
import com.example.school.service.ProfessionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Autowired
    private ProfessionService professionService;

    @Mappings({
            @Mapping(target = "profession", source = "profession.name")
    })
    public abstract EmployeeDTO employeeToDTO(Employee employee);

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
