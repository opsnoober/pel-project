package com.luxixi.domain.dto.studentInfo.outputDto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class OutputStudentInfoDto implements Serializable {

    private Integer id;


    private String stuName;


    private Integer stuGender;


    private Integer stuAge;


    private Date stuBirthday;
}
