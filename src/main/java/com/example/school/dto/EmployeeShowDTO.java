package com.example.school.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeShowDTO {

    private Long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private int age;

    private String profession;

    List<String> roles;

}
