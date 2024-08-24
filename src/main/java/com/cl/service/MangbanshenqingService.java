package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MangbanshenqingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbanshenqingView;


/**
 * 盲板申请
 *
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbanshenqingService extends IService<MangbanshenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MangbanshenqingView> selectListView(Wrapper<MangbanshenqingEntity> wrapper);
   	
   	MangbanshenqingView selectView(@Param("ew") Wrapper<MangbanshenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MangbanshenqingEntity> wrapper);
   	

}

