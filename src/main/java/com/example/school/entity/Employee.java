package com.example.school.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
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

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "id_user"),
                                            inverseJoinColumns = @JoinColumn(name = "id_role"))
    Set<Role> roles;
}
