package com.example.school.validator


import com.example.school.dto.EmployeeCreateDTO
import spock.lang.Specification
import spock.lang.Unroll

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory
import java.util.stream.Collectors

class PasswordValidatorTest extends Specification {

    ValidatorFactory validatorFactory
    Validator validator

    Set<ConstraintViolation<EmployeeCreateDTO>> wrongPasswordMessages
    Set<String> messages

    def setup(){
        validatorFactory = Validation.buildDefaultValidatorFactory()
        validator = validatorFactory.getValidator()
    }


    @Unroll
    def 'Should not valid password. Password: #password'(String password) {

        given:
        EmployeeCreateDTO employeeCreateDTO = prepareEmployeeCreateDTO(password)

        when:
        wrongPasswordMessages = validator.validate(employeeCreateDTO)
        messages = wrongPasswordMessages.stream()
                .map({ constraintViolation -> constraintViolation.message })
                .collect(Collectors.toSet())

        then:
        !messages.isEmpty()

        where:
        password    | _
        null        | _
        ""          | _
        "Janek"     | _
        "Janek123"  | _
        "Janek@"    | _
        "janek123@" | _
        "Janek 123@" | _
        "JanekJanekJanekJanekJanekJanek" | _
    }

    @Unroll
    def 'Should valid password. Password: #password'(String password){

        given:
        EmployeeCreateDTO employeeCreateDTO = prepareEmployeeCreateDTO(password)

        when:
        wrongPasswordMessages = validator.validate(employeeCreateDTO)
        messages = wrongPasswordMessages.stream().map({v -> v.message}).collect(Collectors.toSet())

        then:
        messages.isEmpty()

        where:
        password                    | _
        "Jan1234@"                  | _
        "Janek11!@#^&"              | _
        "janek434DD!"               | _
        "JanekJanekJanekJanek123@@" | _
    }

    private EmployeeCreateDTO prepareEmployeeCreateDTO(String password){
        Set<Long> idRoles = Set.of(1,2) as List<Long>
        return EmployeeCreateDTO.builder()
                .name("Janek")
                .surname("Kowalski")
                .username("janek22")
                .password(password)
                .age(15)
                .profession(1)
                .roles(idRoles).build()
    }


}
