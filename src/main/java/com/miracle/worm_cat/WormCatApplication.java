package com.miracle.worm_cat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = {"com.miracle.worm_cat.mapper"})
public class WormCatApplication {

    public static void main(String[] args) {
        SpringApplication.run(WormCatApplication.class, args);
    }

}
