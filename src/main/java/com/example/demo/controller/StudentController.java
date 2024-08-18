package com.example.demo.controller;

import com.example.demo.entity.Professor;
import com.example.demo.entity.Student;
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

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Student save(@RequestBody Student professor){
        return studentService.save(professor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student professor){
        return studentService.update(professor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/list")
    public List<Student> findAll(){
        return studentService.findAll();
    }


}
