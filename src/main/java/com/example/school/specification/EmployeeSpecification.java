package com.example.school.specification;

import com.example.school.entity.Employee;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "age", params = "age-min", spec = GreaterThanOrEqual.class),
        @Spec(path = "age", params = "age-max", spec = LessThanOrEqual.class),
        @Spec(path = "profession.name", params = "profession", spec = Like.class)
})
public interface EmployeeSpecification extends Specification<Employee> {


}
