package com.example.demo.mapper;

import lombok.AllArgsConstructor;
import com.example.demo.dto.course.AddCourseDTO;
import com.example.demo.dto.course.UpdateCourseDTO;
import com.example.demo.dto.course.ViewCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseMapper {

    private final ModelMapper mapper;

    public Course toEntity(AddCourseDTO addCourseDTO) {
        return mapper.map(addCourseDTO, Course.class);
    }

    public Course toEntity(UpdateCourseDTO updateCourseDTO) {
        return mapper.map(updateCourseDTO, Course.class);
    }

    public ViewCourseDTO toViewDto(Course course) {
        ViewCourseDTO viewCourseDTO = mapper.map(course, ViewCourseDTO.class);

        if (course.getProfessor() != null) {
            String professor = course.getProfessor().getName() + " " + course.getProfessor().getFamily();
            viewCourseDTO.setNameProfessor(professor);
        }

        List<Long> studentNumbers = course.getStudents().stream()
                .map(Student::getStdNumber)
                .toList();

        viewCourseDTO.setStudentNumbers(studentNumbers);

        return viewCourseDTO;
    }

    public List<ViewCourseDTO> toListViewDTO(List<Course> courseList) {
        return courseList.stream().map(this::toViewDto).toList();
    }
}
