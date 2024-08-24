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


import com.cl.dao.MangbanshenqingDao;
import com.cl.entity.MangbanshenqingEntity;
import com.cl.service.MangbanshenqingService;
import com.cl.entity.view.MangbanshenqingView;

@Service("mangbanshenqingService")
public class MangbanshenqingServiceImpl extends ServiceImpl<MangbanshenqingDao, MangbanshenqingEntity> implements MangbanshenqingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MangbanshenqingEntity> page = this.selectPage(
                new Query<MangbanshenqingEntity>(params).getPage(),
                new EntityWrapper<MangbanshenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MangbanshenqingEntity> wrapper) {
		  Page<MangbanshenqingView> page =new Query<MangbanshenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MangbanshenqingView> selectListView(Wrapper<MangbanshenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MangbanshenqingView selectView(Wrapper<MangbanshenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
