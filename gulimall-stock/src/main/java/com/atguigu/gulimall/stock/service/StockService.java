package com.atguigu.gulimall.stock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.stock.entity.StockEntity;

import java.util.Map;

/**
 * 
 *
 * @author kgliu
 * @email kgliu@gmail.com
 * @date 2021-11-21 18:29:24
 */
public interface StockService extends IService<StockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

