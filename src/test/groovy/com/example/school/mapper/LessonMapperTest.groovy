package com.example.school.mapper

import com.example.school.dto.LessonShowDTO
import com.example.school.entity.Employee
import com.example.school.entity.Lesson
import com.example.school.entity.Profession
import com.example.school.entity.Role
import com.example.school.entity.Room
import com.example.school.entity.Subject
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalTime

class LessonMapperTest extends Specification {

    LessonMapper lessonMapper

    def setup() {
        lessonMapper = new LessonMapperImpl()
    }

    def 'Should map lesson entity to lessonDto'() {
        given:
        Lesson lesson = prepareLessonObject()

        when:
        LessonShowDTO lessonDto = lessonMapper.toDTO(lesson)

        then:
        lessonDto != null
        lessonDto.getEmployeeId() == 1
        lessonDto.getRoomId() == 2
        lessonDto.getSubjectId() == 5
    }

    private Lesson prepareLessonObject() {

        Subject subject = new Subject(5, "Math")
        Room room = new Room(2, "12A")
        Profession profession = new Profession(1, "Teacher")
        Set<Role> roles = Set.of(new Role(1, "USER"))
        Employee employee = Employee.builder()
                .id(1)
                .name("Jan")
                .surname("Kowalski")
                .profession(profession)
                .roles(roles).build()

        Lesson lesson = Lesson.builder()
                .id(1)
                .subject(subject)
                .room(room)
                .employee(employee)
                .startLesson(LocalTime.now())
                .endLesson(LocalTime.now())
                .lessonDate(LocalDate.now())
                .build()
        return lesson
    }

}
