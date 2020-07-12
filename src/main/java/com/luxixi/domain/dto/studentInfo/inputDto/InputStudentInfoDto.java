package com.luxixi.domain.dto.studentInfo.inputDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "学生信息-入参")
public class InputStudentInfoDto implements Serializable {

    @ApiModelProperty(value = "学生id")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    @NotBlank(message = "学生姓名不可为空")
    @Size(min = 1,max = 3,message = "姓名长度必须在1~3之间")
    private String stuName;

    @ApiModelProperty(value = "性别 1男2女")
    @NotNull(message = "性别不可为空")
    @Max(2)
    @Min(1)
    private Integer stuGender;

    @ApiModelProperty(value = "年龄")
    @NotNull(message = "年龄不可为空")
    private Integer stuAge;

    @ApiModelProperty(value = "生日")
    @NotNull(message = "生日不可为空")
    @Past(message = "生日必须是过去的日期")
    private Date stuBirthday;

}
