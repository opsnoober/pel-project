package com.luxixi.service;

import com.luxixi.common.result.Result;
import com.luxixi.domain.dto.studentInfo.inputDto.InputStudentInfoDto;

public interface StudentInfoService {

    Result get(Integer id);

    Result insert(InputStudentInfoDto dto);
}
