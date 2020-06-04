package com.uwarterloorookie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan(value = "com.uwarterloorookie.mapper")
public class PersonalwebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalwebsiteApplication.class, args);
    }

}
