package com.atguigu.gulimall.stock;

import com.atguigu.gulimall.stock.entity.StockEntity;
import com.atguigu.gulimall.stock.service.StockService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GulimallStockApplicationTests {

    @Autowired
    StockService stockService;

    @Test
    void contextLoads() {
        StockEntity stockEntity = new StockEntity();

//        stockEntity.setStockname("刘凯歌");
//        stockService.save(stockEntity);
//        System.out.println("保存成功");

        List<StockEntity> list = stockService.list(new QueryWrapper<StockEntity>().eq("id", 1L));
        list.forEach((item)->{
            System.out.println(item);
        });






    }



}
