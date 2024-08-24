package com.cl.entity.view;

import com.cl.entity.MangbanxunjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 盲板巡检
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("mangbanxunjian")
public class MangbanxunjianView  extends MangbanxunjianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MangbanxunjianView(){
	}
 
 	public MangbanxunjianView(MangbanxunjianEntity mangbanxunjianEntity){
 	try {
			BeanUtils.copyProperties(this, mangbanxunjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
