package com.bootmybatisbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BootMybatisBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMybatisBaseApplication.class, args);
    }

}
