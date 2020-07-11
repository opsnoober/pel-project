package com.luxixi;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.luxixi.mapper")
public class PerProjectApplication extends SpringBootServletInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(PerProjectApplication.class);


    //使用外置tomcat    需要继承 SpringBootServletInitializer
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PerProjectApplication.class);
    }

    //使用内置tomcat
    public static void main(String[] args) {
        SpringApplication.run(PerProjectApplication.class, args);
        LOGGER.info("Application Started Successfully");
    }

    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        LOGGER.info(">>>>>>>>>>事务管理类型：" + platformTransactionManager.getClass().getName());
        return new Object();
    }

}
