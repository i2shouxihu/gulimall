package com.atguigu.gulimall.stock.controller;

import java.util.Arrays;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.gulimall.stock.entity.StockEntity;
import com.atguigu.gulimall.stock.service.StockService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;



/**
 * 
 *
 * @author kgliu
 * @email kgliu@gmail.com
 * @date 2021-11-21 18:29:24
 */
@RestController
@RequestMapping("stock/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = stockService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		StockEntity stock = stockService.getById(id);

        return R.ok().put("stock", stock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody StockEntity stock){
		stockService.save(stock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody StockEntity stock){
		stockService.updateById(stock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		stockService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
