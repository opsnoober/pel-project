package com.luxixi.domain.dto.studentInfo.inputDto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
public class InputStudentInfoDto implements Serializable {

    private Integer id;

    @NotBlank(message = "学生姓名不可为空")
    @Size(min = 1,max = 3,message = "姓名长度必须在1~3之间")
    private String stuName;

    @NotNull(message = "性别不可为空")
    @Max(2)
    @Min(1)
    private Integer stuGender;

    @NotNull(message = "年龄不可为空")
    private Integer stuAge;

    @NotNull(message = "生日不可为空")
    @Past(message = "生日必须是过去的日期")
    private Date stuBirthday;

}
