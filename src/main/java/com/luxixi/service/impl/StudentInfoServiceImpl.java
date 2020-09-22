package com.luxixi.service.impl;

import com.luxixi.common.enums.ResultEnum;
import com.luxixi.common.result.Result;
import com.luxixi.dao.StudentInfoDao;
import com.luxixi.domain.dto.studentInfo.inputDto.InputStudentInfoDto;
import com.luxixi.domain.entity.StudentInfoEntity;
import com.luxixi.service.StudentInfoService;
import com.luxixi.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Resource
    private StudentInfoDao studentInfoDao;

    @Override
    public Result get(Integer id) {
        if (id == null || id < 0)
            return ResultUtil.error(ResultEnum.PARAM_ERROR);
        return ResultUtil.success(studentInfoDao.selectByPrimaryKey(id));
    }

    @Override
    public Result insert(InputStudentInfoDto dto) {
        StudentInfoEntity entity = new StudentInfoEntity();
        BeanUtils.copyProperties(dto,entity);
        return ResultUtil.success(studentInfoDao.insert(entity));
    }
}
