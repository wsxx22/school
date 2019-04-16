package com.example.school.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String username;

    private String password;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Profession profession;

    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
    List<Role> roles;

    public Employee(String name, String surname, String username, String password, int age, Profession profession, List<EmployeeRoles> roles) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.profession = profession;
        this.roles = roles;
    }

}
