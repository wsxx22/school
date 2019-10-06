package com.example.school.repository

import com.example.school.entity.Employee
import com.example.school.entity.Profession
import com.example.school.entity.Role
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Specification

@DataJpaTest
class EmployeeRepositorySpec extends Specification {

    @Autowired
    EmployeeRepository employeeRepository

    @Autowired
    TestEntityManager entityManager

    def setup(){
        saveEmployeeToDatabase()
    }

    def 'Should find all employees from database'() {

        when:
        List<Employee> employees = employeeRepository.findAll()

        then:
        employees.size() == 2
    }

    private void saveEmployeeToDatabase() {
        Profession profession = new Profession(1, "Teacher")
        Role userRole = new Role(1, "USER")
        Role adminRole = new Role(2, "ADMIN")
        Employee johnEmployee = Employee.builder()
                .id(1)
                .name("John")
                .surname("Wick")
                .profession(profession)
                .roles([userRole] as Set).build()

        Employee steveEmployee = Employee.builder()
                .id(2)
                .name("Steve")
                .surname("Bruce")
                .profession(profession)
                .roles([userRole, adminRole] as Set).build()

        entityManager.merge(johnEmployee)
        entityManager.merge(steveEmployee)
    }

}
