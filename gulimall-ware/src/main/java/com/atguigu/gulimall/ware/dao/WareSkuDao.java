package com.atguigu.gulimall.ware.dao;

import com.atguigu.gulimall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author kgliu
 * @email 1361893715@qq.com
 * @date 2022-01-03 16:22:40
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
