package com.atguigu.gulimall.stock.dao;

import com.atguigu.gulimall.stock.entity.StockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author kgliu
 * @email kgliu@gmail.com
 * @date 2021-11-21 18:29:24
 */
@Mapper
public interface StockDao{

    @Insert("insert into JobInfo (`title`,`salary`,`company`,`description`,`requirement`,`source`,`url`,`urlMd5`) values (#{title},#{salary},#{company},#{description},#{requirement},#{source},#{url},#{urlMd5})")
    public int add(StockEntity stockEntity);
	
}
