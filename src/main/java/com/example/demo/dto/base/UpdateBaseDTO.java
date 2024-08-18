package com.example.demo.dto.base;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateBaseDTO {
    @NotNull
    private Long id;
}
