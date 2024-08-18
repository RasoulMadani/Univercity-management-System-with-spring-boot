package com.example.demo.dto.professor;
import com.example.demo.dto.user.ViewUserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ViewProfessorDTO extends ViewUserDTO {
    private long code;
    private String academicRank;
    private List<Integer> courseCodes;
}
