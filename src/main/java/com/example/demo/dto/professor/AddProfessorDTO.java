package com.example.demo.dto.professor;

import com.example.demo.dto.user.AddUserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AddProfessorDTO extends AddUserDTO {
    @Positive
    private int code;

    @NotBlank
    private String academicRank;
}
