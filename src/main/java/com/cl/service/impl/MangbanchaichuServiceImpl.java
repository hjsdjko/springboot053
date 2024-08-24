package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MangbanchaichuDao;
import com.cl.entity.MangbanchaichuEntity;
import com.cl.service.MangbanchaichuService;
import com.cl.entity.view.MangbanchaichuView;

@Service("mangbanchaichuService")
public class MangbanchaichuServiceImpl extends ServiceImpl<MangbanchaichuDao, MangbanchaichuEntity> implements MangbanchaichuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MangbanchaichuEntity> page = this.selectPage(
                new Query<MangbanchaichuEntity>(params).getPage(),
                new EntityWrapper<MangbanchaichuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MangbanchaichuEntity> wrapper) {
		  Page<MangbanchaichuView> page =new Query<MangbanchaichuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MangbanchaichuView> selectListView(Wrapper<MangbanchaichuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MangbanchaichuView selectView(Wrapper<MangbanchaichuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
