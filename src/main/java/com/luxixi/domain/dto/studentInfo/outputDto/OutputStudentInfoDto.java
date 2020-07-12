package com.luxixi.domain.dto.studentInfo.outputDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data@ApiModel(value = "学生信息-出参")
public class OutputStudentInfoDto implements Serializable {

    @ApiModelProperty(value = "学生id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String stuName;

    @ApiModelProperty(value = "性别 1男2女")
    private Integer stuGender;

    @ApiModelProperty(value = "年龄")
    private Integer stuAge;

    @ApiModelProperty(value = "生日")
    private Date stuBirthday;
}
