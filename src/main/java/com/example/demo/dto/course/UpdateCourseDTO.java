package com.example.demo.dto.course;

import com.example.demo.dto.base.UpdateBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCourseDTO extends UpdateBaseDTO {
    @NotBlank
    private String title;

    @Positive
    private int units;
}
