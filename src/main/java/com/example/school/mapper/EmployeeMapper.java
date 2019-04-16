package com.example.school.mapper;

import com.example.school.dto.EmployeeCreateDTO;
import com.example.school.dto.EmployeeShowDTO;
import com.example.school.entity.Employee;
import com.example.school.repository.RoleRepository;
import com.example.school.service.ProfessionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeRolesMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class EmployeeMapper {

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private RoleRepository roleRepository;

    @Mappings({
            @Mapping(target = "profession", source = "profession.name"),
            @Mapping(target = "roles", source = "roles.roleId")
    })
    public abstract EmployeeShowDTO employeeToDTO(Employee employee);

    public abstract List<EmployeeShowDTO> employeeToDTOList(List<Employee> employees);

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
                professionService.findById(employeeCreateDTO.getProfession()),
                roleRepository.findAllById(employeeCreateDTO.getRoles()) // ??
        );

    }

}
