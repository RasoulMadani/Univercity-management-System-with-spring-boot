package com.example.demo.service;

import com.example.demo.entity.Professor;
import com.example.demo.exception.ConflictException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public Professor save(Professor professor) {
        Optional<Professor> optional;
        optional = professorRepository.findByNationalCode(professor.getNationalCode());

        if (optional.isPresent())
            throw new ConflictException("The professor with the desired National Code is available in the system.");

        optional = professorRepository.findByUsername(professor.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired username is available in the system .");


        optional = professorRepository.findByCode(professor.getCode());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired code is available in the system .");

        return professorRepository.save(professor);
    }

    public Professor update(Professor professor) {
        findById(professor.getId());
        return professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        findById(id);
        professorRepository.deleteById(id);
    }

    public Professor findById(Long id) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Professor Not found.");
        return optional.get();
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
