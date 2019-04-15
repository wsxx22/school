package com.example.school.mapper;

import com.example.school.dto.SubjectDTO;
import com.example.school.entity.Subject;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {

    SubjectDTO toDTO (Subject subject);

    List<SubjectDTO> toDTOList (List<Subject> subjects);

}
