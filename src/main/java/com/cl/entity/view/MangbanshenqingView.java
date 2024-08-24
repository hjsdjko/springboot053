package com.cl.entity.view;

import com.cl.entity.MangbanshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 盲板申请
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbanshenqing")
public class MangbanshenqingView  extends MangbanshenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MangbanshenqingView(){
	}
 
 	public MangbanshenqingView(MangbanshenqingEntity mangbanshenqingEntity){
 	try {
			BeanUtils.copyProperties(this, mangbanshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
