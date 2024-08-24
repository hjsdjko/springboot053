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


import com.cl.dao.MangbanxunjianDao;
import com.cl.entity.MangbanxunjianEntity;
import com.cl.service.MangbanxunjianService;
import com.cl.entity.view.MangbanxunjianView;

@Service("mangbanxunjianService")
public class MangbanxunjianServiceImpl extends ServiceImpl<MangbanxunjianDao, MangbanxunjianEntity> implements MangbanxunjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MangbanxunjianEntity> page = this.selectPage(
                new Query<MangbanxunjianEntity>(params).getPage(),
                new EntityWrapper<MangbanxunjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MangbanxunjianEntity> wrapper) {
		  Page<MangbanxunjianView> page =new Query<MangbanxunjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MangbanxunjianView> selectListView(Wrapper<MangbanxunjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MangbanxunjianView selectView(Wrapper<MangbanxunjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
