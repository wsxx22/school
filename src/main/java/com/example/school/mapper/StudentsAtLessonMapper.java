package com.example.school.mapper;

import com.example.school.dto.StudentsAtLessonDTO;
import com.example.school.entity.StudentsAtLesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentsAtLessonMapper {

    @Mappings({
            @Mapping(target = "studentId", source = "student.id"),
            @Mapping(target = "lessonId", source = "lesson.id")
    })
    StudentsAtLessonDTO toDTO (StudentsAtLesson studentsAtLesson);

}
