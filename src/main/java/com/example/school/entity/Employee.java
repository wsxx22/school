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
public class Employee extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    private Profession profession;

    @OneToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "_roles", joinColumns = @JoinColumn(name = ""))
    List<Role> roles;

}
