package com.example.demo.service;

import com.example.demo.entity.Course;
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

    public Course update(Course courseUpdate){
        Course byId = findById(courseUpdate.getId());
        courseUpdate.setCode(byId.getCode());
        return courseRepository.save(courseUpdate);
    }

    public void deleteById(Long id){
        findById(id);
        courseRepository.deleteById(id);
    }
    public List<Course> findAll(){
        return courseRepository.findAll();
    }

}

