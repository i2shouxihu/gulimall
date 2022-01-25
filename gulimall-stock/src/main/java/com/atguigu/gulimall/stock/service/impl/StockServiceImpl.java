package com.atguigu.gulimall.stock.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.stock.dao.StockDao;
import com.atguigu.gulimall.stock.entity.StockEntity;
import com.atguigu.gulimall.stock.service.StockService;


@Service("stockService")
public class StockServiceImpl extends ServiceImpl<StockDao, StockEntity> implements StockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<StockEntity> page = this.page(
                new Query<StockEntity>().getPage(params),
                new QueryWrapper<StockEntity>()
        );

        return new PageUtils(page);
    }

}