package com.luxixi.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "student_info")
@ApiModel("学生信息实体类")
public class StudentInfoEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    @ApiModelProperty(value = "学生id")
    private Integer id;

    @Column(name = "stu_name")
    @ApiModelProperty(value = "学生姓名")
    private String stuName;

    @ApiModelProperty(value = "学生性别")
    @Column(name = "stu_gender")
    private Integer stuGender;

    @ApiModelProperty(value = "学生年龄")
    @Column(name = "stu_age")
    private Integer stuAge;

    @ApiModelProperty(value = "学生生日")
    @Column(name = "stu_birthday")
    private Date stuBirthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getStuGender() {
        return stuGender;
    }

    public void setStuGender(Integer stuGender) {
        this.stuGender = stuGender;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Date getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(Date stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

}
