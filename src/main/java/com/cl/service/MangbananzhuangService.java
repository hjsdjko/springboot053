package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.MangbananzhuangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbananzhuangView;


/**
 * 盲板安装
 *
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbananzhuangService extends IService<MangbananzhuangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MangbananzhuangView> selectListView(Wrapper<MangbananzhuangEntity> wrapper);
   	
   	MangbananzhuangView selectView(@Param("ew") Wrapper<MangbananzhuangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MangbananzhuangEntity> wrapper);
   	

}

