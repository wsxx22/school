package com.example.school.mapper;

import com.example.school.dto.EmployeeRolesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface EmployeeRolesMapper {

    EmployeeRolesDTO toDTO (EmployeeRoles employeeRoles);

    List<EmployeeRolesDTO> toDTOList(List<EmployeeRoles> employeeRoles);
}
