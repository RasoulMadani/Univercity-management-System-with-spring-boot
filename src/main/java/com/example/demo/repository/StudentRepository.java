package com.example.demo.repository;

import com.example.demo.entity.Professor;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {
    Optional<Student> findByStdNumber(long stdNumber);

}
