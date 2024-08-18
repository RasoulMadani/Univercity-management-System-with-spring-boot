package com.example.demo.dto.user;

import com.example.demo.dto.base.ViewBaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewUserDTO extends ViewBaseDTO {
    private String name;
    private String family;
    private long nationalCode;
    private String genderString;
    private Long birthDayTimeStamp;
    private String username;
}
