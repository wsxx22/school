package com.example.school.mapper;

import com.example.school.dto.LessonShowDTO;
import com.example.school.entity.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", uses = StudentsAtLessonMapper.class, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface LessonMapper {

    @Mappings({
            @Mapping(target = "subjectId", source = "subject.id"),
            @Mapping(target = "roomId", source = "room.id"),
            @Mapping(target = "employeeId", source = "employee.id"),
    })
    LessonShowDTO toDTO (Lesson lesson);

}
