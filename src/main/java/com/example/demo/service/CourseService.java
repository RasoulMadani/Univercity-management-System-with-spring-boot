package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.exception.ConflictException;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public Course save(Course course){
        Optional<Course> course1 = courseRepository.findByCode(course.getCode());
        if(course1.isPresent())
            throw new ConflictException("The course with the desired code is available in the system .");
        return course1.get();
    }
}

