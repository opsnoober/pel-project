package com.luxixi.perproject;

import com.luxixi.common.properties.TestProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

@SpringBootTest
public class Testt {

    @Resource
    private TestProperties testProperties;

    @Test
    void tt(){
        System.out.println(testProperties);
    }
}
