package com.example.demo.controller;

import com.example.demo.dto.course.ViewCourseDTO;
import com.example.demo.dto.student.AddStudentDTO;
import com.example.demo.dto.student.UpdateStudentDTO;
import com.example.demo.dto.student.ViewStudentDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import com.example.demo.entity.Student;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/v1")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewStudentDTO save(@RequestBody AddStudentDTO addStudentDTO) {
        Student student = studentService.save(studentMapper.toEntity(addStudentDTO));
        return studentMapper.toViewDto(student);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewStudentDTO update(@RequestBody UpdateStudentDTO updateStudentDTO) {
        Student student = studentService.update(studentMapper.toEntity(updateStudentDTO));
        return studentMapper.toViewDto(student);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewStudentDTO findById(@PathVariable Long id) {
        return studentMapper.toViewDto(studentService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewStudentDTO> findAll() {
        return studentMapper.toListViewDTO(studentService.findAll());
    }

    @GetMapping("/{stdNumber}/course/list")
    public List<ViewCourseDTO> listCoursesStudent(@PathVariable long stdNumber) {
        List<Course> courses = studentService.listCoursesStudent(stdNumber);
        return courseMapper.toListViewDTO(courses);
    }


}
