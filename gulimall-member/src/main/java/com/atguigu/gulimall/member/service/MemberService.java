package com.atguigu.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author kgliu
 * @email 1361893715@qq.com
 * @date 2022-01-03 15:50:47
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

