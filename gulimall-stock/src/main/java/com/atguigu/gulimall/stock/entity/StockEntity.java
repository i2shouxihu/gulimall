package com.atguigu.gulimall.stock.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author kgliu
 * @email kgliu@gmail.com
 * @date 2021-11-21 18:29:24
 */
@Data
@TableName("kms_stock")
public class StockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String stockcode;
	/**
	 * 
	 */
	private String stockname;
	/**
	 * 
	 */
	private String industry;
	/**
	 * 
	 */
	private String reason1;
	/**
	 * 
	 */
	private String reason2;
	/**
	 * 
	 */
	private String reason3;
	/**
	 * 
	 */
	private String reason4;
	/**
	 * 
	 */
	private String reason5;
	/**
	 * 
	 */
	private String reason6;
	/**
	 * 
	 */
	private String reason7;
	/**
	 * 
	 */
	private String reason8;
	/**
	 * 
	 */
	private String reason9;
	/**
	 * 
	 */
	private String reason10;
	/**
	 * 
	 */
	private String reason11;
	/**
	 * 
	 */
	private String reason12;
	/**
	 * 
	 */
	private String reason13;
	/**
	 * 
	 */
	private String reason14;
	/**
	 * 
	 */
	private String reason15;

}
