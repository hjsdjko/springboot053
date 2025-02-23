package com.cl.entity.view;

import com.cl.entity.XinwenzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 新闻资讯
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@TableName("xinwenzixun")
public class XinwenzixunView  extends XinwenzixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinwenzixunView(){
	}
 
 	public XinwenzixunView(XinwenzixunEntity xinwenzixunEntity){
 	try {
			BeanUtils.copyProperties(this, xinwenzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
