package com.example.school.mapper;

import com.example.school.dto.RoleDTO;
import com.example.school.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO toDTO (Role role);
    Set<RoleDTO> toDtoSet(Set<Role> roles);
}
