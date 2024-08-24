package com.cl.dao;

import com.cl.entity.MangbananzhuangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbananzhuangView;


/**
 * 盲板安装
 * 
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbananzhuangDao extends BaseMapper<MangbananzhuangEntity> {
	
	List<MangbananzhuangView> selectListView(@Param("ew") Wrapper<MangbananzhuangEntity> wrapper);

	List<MangbananzhuangView> selectListView(Pagination page,@Param("ew") Wrapper<MangbananzhuangEntity> wrapper);
	
	MangbananzhuangView selectView(@Param("ew") Wrapper<MangbananzhuangEntity> wrapper);
	

}
