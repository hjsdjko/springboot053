package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 盲板安装
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbananzhuang")
public class MangbananzhuangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MangbananzhuangEntity() {
		
	}
	
	public MangbananzhuangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 安装人账号
	 */
					
	private String anzhuangrenzhanghao;
	
	/**
	 * 安装姓名
	 */
					
	private String anzhuangxingming;
	
	/**
	 * 盲板位置
	 */
					
	private String mangbanweizhi;
	
	/**
	 * 盲板编号
	 */
					
	private String mangbanbianhao;
	
	/**
	 * 盲板类型
	 */
					
	private String mangbanleixing;
	
	/**
	 * 盲板尺寸
	 */
					
	private String mangbanchicun;
	
	/**
	 * 安装时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date anzhuangshijian;
	
	/**
	 * 安装工具与设备
	 */
					
	private String anzhuanggongjuyushebei;
	
	/**
	 * 安装步骤
	 */
					
	private String anzhuangbuzhou;
	
	/**
	 * 密封检查
	 */
					
	private String mifengjiancha;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：安装人账号
	 */
	public void setAnzhuangrenzhanghao(String anzhuangrenzhanghao) {
		this.anzhuangrenzhanghao = anzhuangrenzhanghao;
	}
	/**
	 * 获取：安装人账号
	 */
	public String getAnzhuangrenzhanghao() {
		return anzhuangrenzhanghao;
	}
	/**
	 * 设置：安装姓名
	 */
	public void setAnzhuangxingming(String anzhuangxingming) {
		this.anzhuangxingming = anzhuangxingming;
	}
	/**
	 * 获取：安装姓名
	 */
	public String getAnzhuangxingming() {
		return anzhuangxingming;
	}
	/**
	 * 设置：盲板位置
	 */
	public void setMangbanweizhi(String mangbanweizhi) {
		this.mangbanweizhi = mangbanweizhi;
	}
	/**
	 * 获取：盲板位置
	 */
	public String getMangbanweizhi() {
		return mangbanweizhi;
	}
	/**
	 * 设置：盲板编号
	 */
	public void setMangbanbianhao(String mangbanbianhao) {
		this.mangbanbianhao = mangbanbianhao;
	}
	/**
	 * 获取：盲板编号
	 */
	public String getMangbanbianhao() {
		return mangbanbianhao;
	}
	/**
	 * 设置：盲板类型
	 */
	public void setMangbanleixing(String mangbanleixing) {
		this.mangbanleixing = mangbanleixing;
	}
	/**
	 * 获取：盲板类型
	 */
	public String getMangbanleixing() {
		return mangbanleixing;
	}
	/**
	 * 设置：盲板尺寸
	 */
	public void setMangbanchicun(String mangbanchicun) {
		this.mangbanchicun = mangbanchicun;
	}
	/**
	 * 获取：盲板尺寸
	 */
	public String getMangbanchicun() {
		return mangbanchicun;
	}
	/**
	 * 设置：安装时间
	 */
	public void setAnzhuangshijian(Date anzhuangshijian) {
		this.anzhuangshijian = anzhuangshijian;
	}
	/**
	 * 获取：安装时间
	 */
	public Date getAnzhuangshijian() {
		return anzhuangshijian;
	}
	/**
	 * 设置：安装工具与设备
	 */
	public void setAnzhuanggongjuyushebei(String anzhuanggongjuyushebei) {
		this.anzhuanggongjuyushebei = anzhuanggongjuyushebei;
	}
	/**
	 * 获取：安装工具与设备
	 */
	public String getAnzhuanggongjuyushebei() {
		return anzhuanggongjuyushebei;
	}
	/**
	 * 设置：安装步骤
	 */
	public void setAnzhuangbuzhou(String anzhuangbuzhou) {
		this.anzhuangbuzhou = anzhuangbuzhou;
	}
	/**
	 * 获取：安装步骤
	 */
	public String getAnzhuangbuzhou() {
		return anzhuangbuzhou;
	}
	/**
	 * 设置：密封检查
	 */
	public void setMifengjiancha(String mifengjiancha) {
		this.mifengjiancha = mifengjiancha;
	}
	/**
	 * 获取：密封检查
	 */
	public String getMifengjiancha() {
		return mifengjiancha;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}

}
