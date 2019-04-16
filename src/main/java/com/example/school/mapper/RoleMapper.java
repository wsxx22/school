package com.example.school.mapper;

import com.example.school.dto.RoleDTO;
import com.example.school.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toDTO (Role role);

}
