package com.cl.dao;

import com.cl.entity.MangbanxunjianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbanxunjianView;


/**
 * 盲板巡检
 * 
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbanxunjianDao extends BaseMapper<MangbanxunjianEntity> {
	
	List<MangbanxunjianView> selectListView(@Param("ew") Wrapper<MangbanxunjianEntity> wrapper);

	List<MangbanxunjianView> selectListView(Pagination page,@Param("ew") Wrapper<MangbanxunjianEntity> wrapper);
	
	MangbanxunjianView selectView(@Param("ew") Wrapper<MangbanxunjianEntity> wrapper);
	

}
