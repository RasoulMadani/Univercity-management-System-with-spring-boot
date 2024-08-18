package com.example.demo.dto.student;

import com.example.demo.dto.user.ViewUserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewStudentDTO extends ViewUserDTO {
    private long stdNumber;
    private String academicLevel;
    private List<Integer> courseCodes;
}
