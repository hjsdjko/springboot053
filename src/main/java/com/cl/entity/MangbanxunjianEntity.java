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
 * 盲板巡检
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbanxunjian")
public class MangbanxunjianEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public MangbanxunjianEntity() {
		
	}
	
	public MangbanxunjianEntity(T t) {
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
	 * 巡检区域
	 */
					
	private String xunjianquyu;
	
	/**
	 * 盲板状态
	 */
					
	private String mangbanzhuangtai;
	
	/**
	 * 紧固情况
	 */
					
	private String jinguqingkuang;
	
	/**
	 * 巡检时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date xunjianshijian;
	
	/**
	 * 泄露检查
	 */
					
	private String xielujiancha;
	
	/**
	 * 周边环境
	 */
					
	private String zhoubianhuanjing;
	
	/**
	 * 问题记录
	 */
					
	private String wentijilu;
	
	/**
	 * 整改措施
	 */
					
	private String zhenggaicuoshi;
	
	/**
	 * 复查时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fuchashijian;
	
	/**
	 * 巡检人账号
	 */
					
	private String xunjianrenzhanghao;
	
	/**
	 * 巡检人姓名
	 */
					
	private String xunjianrenxingming;
	
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
	 * 设置：巡检区域
	 */
	public void setXunjianquyu(String xunjianquyu) {
		this.xunjianquyu = xunjianquyu;
	}
	/**
	 * 获取：巡检区域
	 */
	public String getXunjianquyu() {
		return xunjianquyu;
	}
	/**
	 * 设置：盲板状态
	 */
	public void setMangbanzhuangtai(String mangbanzhuangtai) {
		this.mangbanzhuangtai = mangbanzhuangtai;
	}
	/**
	 * 获取：盲板状态
	 */
	public String getMangbanzhuangtai() {
		return mangbanzhuangtai;
	}
	/**
	 * 设置：紧固情况
	 */
	public void setJinguqingkuang(String jinguqingkuang) {
		this.jinguqingkuang = jinguqingkuang;
	}
	/**
	 * 获取：紧固情况
	 */
	public String getJinguqingkuang() {
		return jinguqingkuang;
	}
	/**
	 * 设置：巡检时间
	 */
	public void setXunjianshijian(Date xunjianshijian) {
		this.xunjianshijian = xunjianshijian;
	}
	/**
	 * 获取：巡检时间
	 */
	public Date getXunjianshijian() {
		return xunjianshijian;
	}
	/**
	 * 设置：泄露检查
	 */
	public void setXielujiancha(String xielujiancha) {
		this.xielujiancha = xielujiancha;
	}
	/**
	 * 获取：泄露检查
	 */
	public String getXielujiancha() {
		return xielujiancha;
	}
	/**
	 * 设置：周边环境
	 */
	public void setZhoubianhuanjing(String zhoubianhuanjing) {
		this.zhoubianhuanjing = zhoubianhuanjing;
	}
	/**
	 * 获取：周边环境
	 */
	public String getZhoubianhuanjing() {
		return zhoubianhuanjing;
	}
	/**
	 * 设置：问题记录
	 */
	public void setWentijilu(String wentijilu) {
		this.wentijilu = wentijilu;
	}
	/**
	 * 获取：问题记录
	 */
	public String getWentijilu() {
		return wentijilu;
	}
	/**
	 * 设置：整改措施
	 */
	public void setZhenggaicuoshi(String zhenggaicuoshi) {
		this.zhenggaicuoshi = zhenggaicuoshi;
	}
	/**
	 * 获取：整改措施
	 */
	public String getZhenggaicuoshi() {
		return zhenggaicuoshi;
	}
	/**
	 * 设置：复查时间
	 */
	public void setFuchashijian(Date fuchashijian) {
		this.fuchashijian = fuchashijian;
	}
	/**
	 * 获取：复查时间
	 */
	public Date getFuchashijian() {
		return fuchashijian;
	}
	/**
	 * 设置：巡检人账号
	 */
	public void setXunjianrenzhanghao(String xunjianrenzhanghao) {
		this.xunjianrenzhanghao = xunjianrenzhanghao;
	}
	/**
	 * 获取：巡检人账号
	 */
	public String getXunjianrenzhanghao() {
		return xunjianrenzhanghao;
	}
	/**
	 * 设置：巡检人姓名
	 */
	public void setXunjianrenxingming(String xunjianrenxingming) {
		this.xunjianrenxingming = xunjianrenxingming;
	}
	/**
	 * 获取：巡检人姓名
	 */
	public String getXunjianrenxingming() {
		return xunjianrenxingming;
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
