package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course/v1")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Course save(@RequestBody Course course){
        return courseService.save(course);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Course update(@RequestBody Course course){
        return courseService.save(course);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        courseService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public Course findById(@PathVariable Long id){
        return courseService.findById(id);
    }

    @GetMapping("/list")
    public List<Course> findAll(){
        return courseService.findAll();
    }


}
