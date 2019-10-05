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
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {EmployeeRolesMapper.class, RoleMapper.class}, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class EmployeeMapper {

    @Autowired
    private ProfessionService professionService;

    @Autowired
    private RoleRepository roleRepository;

    @Mapping(target = "profession", source = "profession.name")
    public abstract EmployeeShowDTO employeeToDTO(Employee employee);

    public abstract List<EmployeeShowDTO> employeeToDTOList(List<Employee> employees);

    public Employee employeeDTOToEmployeeEntity(EmployeeCreateDTO employeeCreateDTO) {

        EmployeeCreateDTO employeeDTO = Optional.ofNullable(employeeCreateDTO)
                .orElseThrow(() -> new RuntimeException("EmployeeCreateDto doesn't exists."));

        return Employee.builder()
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .username(employeeDTO.getUsername())
                .password(employeeDTO.getPassword())
                .age(employeeDTO.getAge())
                .profession(professionService.findById(employeeDTO.getProfession()))
                .roles(roleRepository.findAllById(employeeDTO.getRoles())).build();
    }

}
