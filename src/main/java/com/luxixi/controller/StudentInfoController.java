package com.luxixi.controller;

import com.luxixi.common.result.Result;
import com.luxixi.domain.dto.studentInfo.inputDto.InputStudentInfoDto;
import com.luxixi.service.StudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/stu")
@Api(tags = "学生信息管理")
public class StudentInfoController extends BaseController{

    @Autowired
    private StudentInfoService studentInfoService;

    @ApiOperation(value = "根据id获取学生信息")
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return studentInfoService.get(id);
    }

    @ApiOperation(value = "添加学生信息")
    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @Valid InputStudentInfoDto dto, HttpServletRequest request){
        System.out.println(request.getMethod());
        return studentInfoService.insert(dto);
    }
}
