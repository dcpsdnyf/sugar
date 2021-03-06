package com.sugar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.sugar.manage.dao.mapper")
public class SugarManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SugarManageApplication.class, args);
    }

}
