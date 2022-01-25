package com.atguigu.gulimall.stock.pipeline;

import com.atguigu.gulimall.stock.dao.StockDao;
import com.atguigu.gulimall.stock.entity.StockEntity;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;



@Component("StockDaoPipeline")
public class StockDaoPipeline implements PageModelPipeline<StockEntity> {

    @Resource
    private StockDao stockDao;

    @Override
    public void process(StockEntity stockEntity, Task task) {
        //调用MyBatis DAO保存结果
        stockDao.add(stockEntity);
    }
}
