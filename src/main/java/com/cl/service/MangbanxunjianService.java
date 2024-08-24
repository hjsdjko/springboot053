package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MangbanxunjianEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbanxunjianView;


/**
 * 盲板巡检
 *
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbanxunjianService extends IService<MangbanxunjianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MangbanxunjianView> selectListView(Wrapper<MangbanxunjianEntity> wrapper);
   	
   	MangbanxunjianView selectView(@Param("ew") Wrapper<MangbanxunjianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MangbanxunjianEntity> wrapper);
   	

}

