package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
    Optional<Professor> findByCode(int code);
}
