package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.MangbanshenqingEntity;
import com.cl.entity.view.MangbanshenqingView;

import com.cl.service.MangbanshenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 盲板申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@RestController
@RequestMapping("/mangbanshenqing")
public class MangbanshenqingController {
    @Autowired
    private MangbanshenqingService mangbanshenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MangbanshenqingEntity mangbanshenqing,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shenqingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shenqingshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mangbanshenqing.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MangbanshenqingEntity> ew = new EntityWrapper<MangbanshenqingEntity>();
                if(shenqingshijianstart!=null) ew.ge("shenqingshijian", shenqingshijianstart);
                if(shenqingshijianend!=null) ew.le("shenqingshijian", shenqingshijianend);

		PageUtils page = mangbanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanshenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MangbanshenqingEntity mangbanshenqing, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shenqingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date shenqingshijianend,
		HttpServletRequest request){
        EntityWrapper<MangbanshenqingEntity> ew = new EntityWrapper<MangbanshenqingEntity>();
                if(shenqingshijianstart!=null) ew.ge("shenqingshijian", shenqingshijianstart);
                if(shenqingshijianend!=null) ew.le("shenqingshijian", shenqingshijianend);

		PageUtils page = mangbanshenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanshenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MangbanshenqingEntity mangbanshenqing){
       	EntityWrapper<MangbanshenqingEntity> ew = new EntityWrapper<MangbanshenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mangbanshenqing, "mangbanshenqing")); 
        return R.ok().put("data", mangbanshenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MangbanshenqingEntity mangbanshenqing){
        EntityWrapper< MangbanshenqingEntity> ew = new EntityWrapper< MangbanshenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mangbanshenqing, "mangbanshenqing")); 
		MangbanshenqingView mangbanshenqingView =  mangbanshenqingService.selectView(ew);
		return R.ok("查询盲板申请成功").put("data", mangbanshenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MangbanshenqingEntity mangbanshenqing = mangbanshenqingService.selectById(id);
		mangbanshenqing = mangbanshenqingService.selectView(new EntityWrapper<MangbanshenqingEntity>().eq("id", id));
        return R.ok().put("data", mangbanshenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MangbanshenqingEntity mangbanshenqing = mangbanshenqingService.selectById(id);
		mangbanshenqing = mangbanshenqingService.selectView(new EntityWrapper<MangbanshenqingEntity>().eq("id", id));
        return R.ok().put("data", mangbanshenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MangbanshenqingEntity mangbanshenqing, HttpServletRequest request){
    	mangbanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanshenqing);
        mangbanshenqingService.insert(mangbanshenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MangbanshenqingEntity mangbanshenqing, HttpServletRequest request){
    	mangbanshenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanshenqing);
        mangbanshenqingService.insert(mangbanshenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MangbanshenqingEntity mangbanshenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mangbanshenqing);
        mangbanshenqingService.updateById(mangbanshenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<MangbanshenqingEntity> list = new ArrayList<MangbanshenqingEntity>();
        for(Long id : ids) {
            MangbanshenqingEntity mangbanshenqing = mangbanshenqingService.selectById(id);
            mangbanshenqing.setSfsh(sfsh);
            mangbanshenqing.setShhf(shhf);
            list.add(mangbanshenqing);
        }
        mangbanshenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mangbanshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
