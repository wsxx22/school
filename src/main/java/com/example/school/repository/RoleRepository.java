package com.example.school.repository;

import com.example.school.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


    Set<Role> findAllById (Set<Long> id);

}
