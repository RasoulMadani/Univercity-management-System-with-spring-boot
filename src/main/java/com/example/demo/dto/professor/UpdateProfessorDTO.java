package com.example.demo.dto.professor;

import com.example.demo.dto.user.UpdateUserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProfessorDTO extends UpdateUserDTO {
    @NotBlank
    private String academicRank;
}
