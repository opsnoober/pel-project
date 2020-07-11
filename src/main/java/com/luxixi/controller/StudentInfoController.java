package com.luxixi.controller;

import com.luxixi.common.result.Result;
import com.luxixi.domain.dto.studentInfo.inputDto.InputStudentInfoDto;
import com.luxixi.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/stu")
public class StudentInfoController extends BaseController{

    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return studentInfoService.get(id);
    }

    @PostMapping(value = "/insert")
    public Result insert(@RequestBody @Valid InputStudentInfoDto dto, HttpServletRequest request){
        System.out.println(request.getMethod());
        return studentInfoService.insert(dto);
    }
}
