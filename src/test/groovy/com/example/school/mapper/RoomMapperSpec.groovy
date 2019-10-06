package com.example.school.mapper

import com.example.school.dto.RoleDTO
import com.example.school.entity.Role
import spock.lang.Specification

class RoomMapperSpec extends Specification {

    RoleMapper roleMapper

    def setup(){
        roleMapper = new RoleMapperImpl()
    }

    def 'Should map Role entity to RoleDto'() {

        given:
        Role role = new Role(1, "Admin")

        when:
        RoleDTO roleDTO = roleMapper.toDTO(role)

        then:
        roleDTO.getId() == 1
        roleDTO.getRole() == "Admin"
    }

    def 'Should map roles to RolesDto'() {

        given:
        Set<Role> roles = prepareRoles()

        when:
        Set<RoleDTO> rolesDTO = roleMapper.toDtoSet(roles)

        then:
        rolesDTO.size() == 3
        rolesDTO.stream().filter({r -> r.getRole() == "User"}).count() == 1
    }

    private Set<Role> prepareRoles() {
        return [new Role(1, "Admin"),
                new Role(2, "User"),
                new Role(3, "Guest")]
    }

}
