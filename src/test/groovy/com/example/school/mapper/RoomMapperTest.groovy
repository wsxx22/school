package com.example.school.mapper

import com.example.school.dto.RoleDTO
import com.example.school.entity.Role
import spock.lang.Specification

class RoomMapperTest extends Specification {

    RoleMapper roleMapper

    def setup(){
        roleMapper = new RoleMapperImpl()
    }

    def 'Should map Role entity to RoleDto'() {

        given:
        Role role = new Role(1, "Teacher")

        when:
        RoleDTO roleDTO = roleMapper.toDTO(role)

        then:
        roleDTO.getId() == 1
        roleDTO.getRole() == "Teacher"
    }

    def 'Should map roles to RolesDto'() {

        given:
        Set<Role> roles = prepareRoles()

        when:
        Set<RoleDTO> rolesDTO = roleMapper.toDtoSet(roles)

        then:
        rolesDTO.size() == 3
        rolesDTO.stream().filter({r -> r.getRole() == "Caretaker"}).count() == 1
    }

    private Set<Role> prepareRoles() {
        return Set.of(
                new Role(1, "Teacher"),
                new Role(2, "Administrator"),
                new Role(3, "Caretaker"))
    }

}
