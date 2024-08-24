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

import com.cl.entity.MangbanxunjianEntity;
import com.cl.entity.view.MangbanxunjianView;

import com.cl.service.MangbanxunjianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 盲板巡检
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@RestController
@RequestMapping("/mangbanxunjian")
public class MangbanxunjianController {
    @Autowired
    private MangbanxunjianService mangbanxunjianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MangbanxunjianEntity mangbanxunjian,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xunjianshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xunjianshijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mangbanxunjian.setXunjianrenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MangbanxunjianEntity> ew = new EntityWrapper<MangbanxunjianEntity>();
                if(xunjianshijianstart!=null) ew.ge("xunjianshijian", xunjianshijianstart);
                if(xunjianshijianend!=null) ew.le("xunjianshijian", xunjianshijianend);

		PageUtils page = mangbanxunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanxunjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MangbanxunjianEntity mangbanxunjian, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xunjianshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date xunjianshijianend,
		HttpServletRequest request){
        EntityWrapper<MangbanxunjianEntity> ew = new EntityWrapper<MangbanxunjianEntity>();
                if(xunjianshijianstart!=null) ew.ge("xunjianshijian", xunjianshijianstart);
                if(xunjianshijianend!=null) ew.le("xunjianshijian", xunjianshijianend);

		PageUtils page = mangbanxunjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanxunjian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MangbanxunjianEntity mangbanxunjian){
       	EntityWrapper<MangbanxunjianEntity> ew = new EntityWrapper<MangbanxunjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mangbanxunjian, "mangbanxunjian")); 
        return R.ok().put("data", mangbanxunjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MangbanxunjianEntity mangbanxunjian){
        EntityWrapper< MangbanxunjianEntity> ew = new EntityWrapper< MangbanxunjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mangbanxunjian, "mangbanxunjian")); 
		MangbanxunjianView mangbanxunjianView =  mangbanxunjianService.selectView(ew);
		return R.ok("查询盲板巡检成功").put("data", mangbanxunjianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MangbanxunjianEntity mangbanxunjian = mangbanxunjianService.selectById(id);
		mangbanxunjian = mangbanxunjianService.selectView(new EntityWrapper<MangbanxunjianEntity>().eq("id", id));
        return R.ok().put("data", mangbanxunjian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MangbanxunjianEntity mangbanxunjian = mangbanxunjianService.selectById(id);
		mangbanxunjian = mangbanxunjianService.selectView(new EntityWrapper<MangbanxunjianEntity>().eq("id", id));
        return R.ok().put("data", mangbanxunjian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MangbanxunjianEntity mangbanxunjian, HttpServletRequest request){
    	mangbanxunjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanxunjian);
        mangbanxunjianService.insert(mangbanxunjian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MangbanxunjianEntity mangbanxunjian, HttpServletRequest request){
    	mangbanxunjian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanxunjian);
        mangbanxunjianService.insert(mangbanxunjian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MangbanxunjianEntity mangbanxunjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mangbanxunjian);
        mangbanxunjianService.updateById(mangbanxunjian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mangbanxunjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
