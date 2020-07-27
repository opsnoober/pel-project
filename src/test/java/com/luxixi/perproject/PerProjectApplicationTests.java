package com.luxixi.perproject;

import com.luxixi.dao.StudentInfoDao;
import com.luxixi.domain.entity.StudentInfoEntity;
import com.luxixi.utils.ResultUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
class PerProjectApplicationTests {

    @Resource
    private StudentInfoDao studentInfoDao;

    @Test
    void contextLoads() {
        StudentInfoEntity entity = studentInfoDao.selectByPrimaryKey(47);
        System.out.println(ResultUtil.success(entity.getStuBirthday()));
        System.out.println(new Date());
    }

}
