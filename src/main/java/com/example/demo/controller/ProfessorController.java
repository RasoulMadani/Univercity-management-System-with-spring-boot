package com.example.demo.controller;

import com.example.demo.dto.course.ViewCourseDTO;
import com.example.demo.dto.professor.AddProfessorDTO;
import com.example.demo.dto.professor.UpdateProfessorDTO;
import com.example.demo.dto.professor.ViewProfessorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.ProfessorMapper;
import com.example.demo.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor/v1")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;
    private final ProfessorMapper professorMapper;
    private final CourseMapper courseMapper;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ViewProfessorDTO save(@RequestBody AddProfessorDTO addProfessorDTO) {
        Professor professor = professorService.save(professorMapper.toEntity(addProfessorDTO));
        return professorMapper.toViewDto(professor);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ViewProfessorDTO update(@RequestBody UpdateProfessorDTO updateProfessorDTO) {
        Professor professor = professorService.save(professorMapper.toEntity(updateProfessorDTO));
        return professorMapper.toViewDto(professor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        professorService.deleteById(id);
    }

    @GetMapping("/find/{id}")
    public ViewProfessorDTO findById(@PathVariable Long id) {
        return professorMapper.toViewDto(professorService.findById(id));
    }

    @GetMapping("/list")
    public List<ViewProfessorDTO> findAll() {
        return professorMapper.toListViewDTO(professorService.findAll());
    }

    @GetMapping("/{codeProfessor}/course/list")
    public List<ViewCourseDTO> listCoursesProfessor(@PathVariable int codeProfessor) {
        List<Course> courses = professorService.listCoursesProfessor(codeProfessor);
        return courseMapper.toListViewDTO(courses);
    }

}
