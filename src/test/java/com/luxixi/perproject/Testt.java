package com.luxixi.perproject;

import com.luxixi.common.properties.TestProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Testt {


    @Resource
    private TestProperties testProperties;

    @Test
    void tt(){
        System.out.println(testProperties);
    }

    @Test
    void tt1(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = null;
        list1.add("ddddd");
        list1.addAll(list2);
        System.out.println(list1);
    }
}
