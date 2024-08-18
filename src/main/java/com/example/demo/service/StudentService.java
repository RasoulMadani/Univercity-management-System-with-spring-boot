package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import com.example.demo.entity.Student;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Student save(Student student) {
        Optional<Student> optional;
        optional = studentRepository.findByNationalCode(student.getNationalCode());

        if (optional.isPresent())
            throw new ConflictException("The student with the desired National Code is available in the system.");

        optional = studentRepository.findByUsername(student.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired username is available in the system .");


        optional = studentRepository.findByStdNumber(student.getStdNumber());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired code is available in the system .");

        return studentRepository.save(student);
    }
    public Student update(Student student){
        findById(student.getId());
        return studentRepository.save(student);
    }
    public void deletedBy(Long id){
        findById(id);
        studentRepository.deleteById(id);
    }
    public Student findById (Long id){
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isEmpty())
            throw new NotFoundException("Student Not Found.");
        return optional.get();
    }
    public void deleteById(Long id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    public Student findByStdNumber(Long stdNumber){
        Optional<Student> optional = studentRepository.findByStdNumber(stdNumber);
        if(optional.isEmpty())
            throw new NotFoundException("Student Not found.");
        return optional.get();
    }
    public List<Course> listCoursesStudent(long stdNumber) {
        Student student = findByStdNumber(stdNumber);
        return student.getCourses().stream().toList();
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
}
