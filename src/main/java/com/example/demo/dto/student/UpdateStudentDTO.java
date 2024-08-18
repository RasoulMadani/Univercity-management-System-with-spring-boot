package com.example.demo.dto.student;

import com.example.demo.dto.user.UpdateUserDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateStudentDTO extends UpdateUserDTO {
    @NotBlank
    private String academicLevel;
}
