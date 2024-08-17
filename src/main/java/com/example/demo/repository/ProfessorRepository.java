package com.example.demo.repository;

import com.example.demo.entity.Professor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
}
