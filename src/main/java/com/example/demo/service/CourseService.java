package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import com.example.demo.entity.Student;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;
    public Course save(Course course){
        Optional<Course> course1 = courseRepository.findByCode(course.getCode());
        if(course1.isPresent())
            throw new ConflictException("The course with the desired code is available in the system .");
        return courseRepository.save(course);
    }

    public Course findById(Long id){
        Optional<Course> optional = courseRepository.findById(id);
        if(optional.isEmpty())
            throw new NotFoundException("Course Not found.");
        return optional.get();
    }
    public void removeStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);

        if (!course.getStudents().contains(student))
            throw new NotFoundException("The student does not have this course.");
        course.getStudents().remove(student);
        student.getCourses().remove(course);

        studentService.update(student);
        update(course);
    }
    public void addProfessor(int codeCourse, int codeProfessor) {
        Professor professor = professorService.findByCode(codeProfessor);
        Course course = findByCode(codeCourse);

        course.setProfessor(professor);
        professor.getCourses().add(course);

        professorService.update(professor);
        update(course);
    }
    public Course update(Course courseUpdate){
        Course byId = findById(courseUpdate.getId());
        courseUpdate.setCode(byId.getCode());
        return courseRepository.save(courseUpdate);
    }
    public Course findByCode(int code) {
        Optional<Course> optional = courseRepository.findByCode(code);
        if (optional.isEmpty())
            throw new NotFoundException("Course Not found.");
        return optional.get();
    }
    public List<Student> listStudents(int codeCourse) {
        return findByCode(codeCourse).getStudents().stream().toList();
    }

    public void addStudent(int codeCourse, long stdNumber) {
        Student student = studentService.findByStdNumber(stdNumber);
        Course course = findByCode(codeCourse);

        course.getStudents().add(student);
        student.getCourses().add(course);

        studentService.update(student);
        update(course);
    }

    public void deleteById(Long id){
        findById(id);
        courseRepository.deleteById(id);
    }
    public void removeProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");

        Professor professor = course.getProfessor();
        course.setProfessor(null);

        professor.getCourses().remove(course);

        professorService.update(professor);
        update(course);
    }
    public Professor getProfessor(int codeCourse) {
        Course course = findByCode(codeCourse);
        if (course.getProfessor() == null)
            throw new NotFoundException("The professor is not set for this course.");
        return course.getProfessor();
    }
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

}

