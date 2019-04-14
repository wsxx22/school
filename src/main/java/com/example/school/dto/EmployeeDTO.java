package com.example.school.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDTO {

    private Long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private int age;

    private String profession;

}
