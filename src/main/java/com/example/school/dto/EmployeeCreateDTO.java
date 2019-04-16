package com.example.school.dto;

import com.example.school.annotation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeCreateDTO {

    @NotBlank(message = "Pole nie moze byc puste")
    private String name;

    @NotBlank(message = "Field cannot be empty")
    private String surname;

    @Length(min = 5, message = "Login must contain 5 characters")
    private String username;

    @ValidPassword
    private String password;

    @Min(value = 10)
    private int age;

    private Long profession;

    private List<Long> roles;

}
