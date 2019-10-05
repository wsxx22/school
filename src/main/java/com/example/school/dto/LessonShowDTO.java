package com.example.school.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LessonShowDTO {

    private Long id;

    private Long subjectId;

    private Long roomId;

    private Long employeeId;

    private List<StudentsAtLessonDTO> studentsAtLessonDTO;

    private LocalTime startLesson;

    private LocalTime endLesson;

    private LocalDate lessonDate;

}
