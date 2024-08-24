package com.cl.entity.view;

import com.cl.entity.MangbanchaichuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 盲板拆除
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbanchaichu")
public class MangbanchaichuView  extends MangbanchaichuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MangbanchaichuView(){
	}
 
 	public MangbanchaichuView(MangbanchaichuEntity mangbanchaichuEntity){
 	try {
			BeanUtils.copyProperties(this, mangbanchaichuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
