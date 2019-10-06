package com.example.school.repository

import com.example.school.entity.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Specification

@DataJpaTest
class RoleRepositorySpec extends Specification{

    @Autowired
    TestEntityManager entityManager

    @Autowired
    RoleRepository roleRepository

    def setup(){
        saveRoles()
    }

    def 'Should find all roles by id.'() {

        when:
        Set<Role> roles = roleRepository.findAllById([1L,2L])

        then:
        roles.size() == 2
        roles.stream().filter({r->r.id == 2L}).findFirst().get().role == "User"
    }

    def 'Should find all roles'(){

        when:
        List<Role> allRoles = roleRepository.findAll()

        then:
        allRoles.size() == 3
    }

    private void saveRoles(){
        Set<Role> roles = [
                new Role(1L, "Admin"),
                new Role(2L, "User"),
                new Role(3L, "Caretaker")]
        roles.each {entityManager.merge(it)}
    }
}