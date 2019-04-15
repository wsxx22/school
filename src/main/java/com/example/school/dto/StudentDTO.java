package com.example.school.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Min(value = 8, message = "Minimum age is 8.")
    private int age;

    @Min(1)
    @Max(8)
    private int yearOfStudy;

}
