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
 * 盲板拆除
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbanchaichu")
public class MangbanchaichuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MangbanchaichuEntity() {
		
	}
	
	public MangbanchaichuEntity(T t) {
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
	 * 盲板编号
	 */
					
	private String mangbanbianhao;
	
	/**
	 * 盲板类型
	 */
					
	private String mangbanleixing;
	
	/**
	 * 盲板位置
	 */
					
	private String mangbanweizhi;
	
	/**
	 * 拆除步骤
	 */
					
	private String chaichubuzhou;
	
	/**
	 * 安全措施
	 */
					
	private String anquancuoshi;
	
	/**
	 * 拆除工具
	 */
					
	private String chaichugongju;
	
	/**
	 * 密封检测
	 */
					
	private String mifengjiance;
	
	/**
	 * 废弃物处理
	 */
					
	private String feiqiwuchuli;
	
	/**
	 * 拆除时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date chaichushijian;
	
	/**
	 * 拆除人账号
	 */
					
	private String chaichurenzhanghao;
	
	/**
	 * 拆除人姓名
	 */
					
	private String chaichurenxingming;
	
	/**
	 * 是否审核
	 */
					
	private String sfsh;
	
	/**
	 * 回复内容
	 */
					
	private String shhf;
	
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
	 * 设置：拆除步骤
	 */
	public void setChaichubuzhou(String chaichubuzhou) {
		this.chaichubuzhou = chaichubuzhou;
	}
	/**
	 * 获取：拆除步骤
	 */
	public String getChaichubuzhou() {
		return chaichubuzhou;
	}
	/**
	 * 设置：安全措施
	 */
	public void setAnquancuoshi(String anquancuoshi) {
		this.anquancuoshi = anquancuoshi;
	}
	/**
	 * 获取：安全措施
	 */
	public String getAnquancuoshi() {
		return anquancuoshi;
	}
	/**
	 * 设置：拆除工具
	 */
	public void setChaichugongju(String chaichugongju) {
		this.chaichugongju = chaichugongju;
	}
	/**
	 * 获取：拆除工具
	 */
	public String getChaichugongju() {
		return chaichugongju;
	}
	/**
	 * 设置：密封检测
	 */
	public void setMifengjiance(String mifengjiance) {
		this.mifengjiance = mifengjiance;
	}
	/**
	 * 获取：密封检测
	 */
	public String getMifengjiance() {
		return mifengjiance;
	}
	/**
	 * 设置：废弃物处理
	 */
	public void setFeiqiwuchuli(String feiqiwuchuli) {
		this.feiqiwuchuli = feiqiwuchuli;
	}
	/**
	 * 获取：废弃物处理
	 */
	public String getFeiqiwuchuli() {
		return feiqiwuchuli;
	}
	/**
	 * 设置：拆除时间
	 */
	public void setChaichushijian(Date chaichushijian) {
		this.chaichushijian = chaichushijian;
	}
	/**
	 * 获取：拆除时间
	 */
	public Date getChaichushijian() {
		return chaichushijian;
	}
	/**
	 * 设置：拆除人账号
	 */
	public void setChaichurenzhanghao(String chaichurenzhanghao) {
		this.chaichurenzhanghao = chaichurenzhanghao;
	}
	/**
	 * 获取：拆除人账号
	 */
	public String getChaichurenzhanghao() {
		return chaichurenzhanghao;
	}
	/**
	 * 设置：拆除人姓名
	 */
	public void setChaichurenxingming(String chaichurenxingming) {
		this.chaichurenxingming = chaichurenxingming;
	}
	/**
	 * 获取：拆除人姓名
	 */
	public String getChaichurenxingming() {
		return chaichurenxingming;
	}
	/**
	 * 设置：是否审核
	 */
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
	/**
	 * 设置：回复内容
	 */
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
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
