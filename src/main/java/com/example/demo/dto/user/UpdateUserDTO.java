package com.example.demo.dto.user;

import com.example.demo.dto.base.UpdateBaseDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserDTO extends UpdateBaseDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String family;

    @NotBlank
    private String genderString;

    @NotNull
    private Long birthDayTimeStamp;

    @NotBlank
    private String password;
}
