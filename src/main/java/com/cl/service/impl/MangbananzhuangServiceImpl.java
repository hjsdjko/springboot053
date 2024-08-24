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


import com.cl.dao.MangbananzhuangDao;
import com.cl.entity.MangbananzhuangEntity;
import com.cl.service.MangbananzhuangService;
import com.cl.entity.view.MangbananzhuangView;

@Service("mangbananzhuangService")
public class MangbananzhuangServiceImpl extends ServiceImpl<MangbananzhuangDao, MangbananzhuangEntity> implements MangbananzhuangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MangbananzhuangEntity> page = this.selectPage(
                new Query<MangbananzhuangEntity>(params).getPage(),
                new EntityWrapper<MangbananzhuangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MangbananzhuangEntity> wrapper) {
		  Page<MangbananzhuangView> page =new Query<MangbananzhuangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MangbananzhuangView> selectListView(Wrapper<MangbananzhuangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MangbananzhuangView selectView(Wrapper<MangbananzhuangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
