package com.example.demo.dto.student;

import com.example.demo.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddStudentDTO extends AddUserDTO {
    @Positive
    private long stdNumber;

    @NotBlank
    private String academicLevel;
}
