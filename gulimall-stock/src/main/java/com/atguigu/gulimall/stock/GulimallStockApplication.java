package com.atguigu.gulimall.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.atguigu.gulimall.stock.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimallStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallStockApplication.class, args);
    }

}
