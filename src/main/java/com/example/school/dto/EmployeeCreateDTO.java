package com.example.school.dto;

import com.example.school.annotation.ValidPassword;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateDTO {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @Length(min = 5, message = "Login must contain 5 characters")
    private String username;

    @ValidPassword
    private String password;

    @Min(value = 10)
    private int age;

    private Long profession;

    private Set<Long> roles;

}
