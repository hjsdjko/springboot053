package com.cl.dao;

import com.cl.entity.MangbanchaichuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MangbanchaichuView;


/**
 * 盲板拆除
 * 
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
public interface MangbanchaichuDao extends BaseMapper<MangbanchaichuEntity> {
	
	List<MangbanchaichuView> selectListView(@Param("ew") Wrapper<MangbanchaichuEntity> wrapper);

	List<MangbanchaichuView> selectListView(Pagination page,@Param("ew") Wrapper<MangbanchaichuEntity> wrapper);
	
	MangbanchaichuView selectView(@Param("ew") Wrapper<MangbanchaichuEntity> wrapper);
	

}
