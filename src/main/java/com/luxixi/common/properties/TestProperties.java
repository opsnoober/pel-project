package com.luxixi.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Data
@Component
@PropertySource(value = "classpath:test.properties")
public class TestProperties {

    @Value("${aa.name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${agent}")
    private String agent;



}
