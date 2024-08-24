package com.cl.dao;

import com.cl.entity.MangbanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbanshenqingView;


/**
 * 盲板申请
 * 
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbanshenqingDao extends BaseMapper<MangbanshenqingEntity> {
	
	List<MangbanshenqingView> selectListView(@Param("ew") Wrapper<MangbanshenqingEntity> wrapper);

	List<MangbanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<MangbanshenqingEntity> wrapper);
	
	MangbanshenqingView selectView(@Param("ew") Wrapper<MangbanshenqingEntity> wrapper);
	

}
