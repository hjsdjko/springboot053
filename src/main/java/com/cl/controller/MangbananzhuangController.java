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

import com.cl.entity.MangbananzhuangEntity;
import com.cl.entity.view.MangbananzhuangView;

import com.cl.service.MangbananzhuangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 盲板安装
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@RestController
@RequestMapping("/mangbananzhuang")
public class MangbananzhuangController {
    @Autowired
    private MangbananzhuangService mangbananzhuangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MangbananzhuangEntity mangbananzhuang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mangbananzhuang.setAnzhuangrenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MangbananzhuangEntity> ew = new EntityWrapper<MangbananzhuangEntity>();

		PageUtils page = mangbananzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbananzhuang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MangbananzhuangEntity mangbananzhuang, 
		HttpServletRequest request){
        EntityWrapper<MangbananzhuangEntity> ew = new EntityWrapper<MangbananzhuangEntity>();

		PageUtils page = mangbananzhuangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbananzhuang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MangbananzhuangEntity mangbananzhuang){
       	EntityWrapper<MangbananzhuangEntity> ew = new EntityWrapper<MangbananzhuangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mangbananzhuang, "mangbananzhuang")); 
        return R.ok().put("data", mangbananzhuangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MangbananzhuangEntity mangbananzhuang){
        EntityWrapper< MangbananzhuangEntity> ew = new EntityWrapper< MangbananzhuangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mangbananzhuang, "mangbananzhuang")); 
		MangbananzhuangView mangbananzhuangView =  mangbananzhuangService.selectView(ew);
		return R.ok("查询盲板安装成功").put("data", mangbananzhuangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MangbananzhuangEntity mangbananzhuang = mangbananzhuangService.selectById(id);
		mangbananzhuang = mangbananzhuangService.selectView(new EntityWrapper<MangbananzhuangEntity>().eq("id", id));
        return R.ok().put("data", mangbananzhuang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MangbananzhuangEntity mangbananzhuang = mangbananzhuangService.selectById(id);
		mangbananzhuang = mangbananzhuangService.selectView(new EntityWrapper<MangbananzhuangEntity>().eq("id", id));
        return R.ok().put("data", mangbananzhuang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MangbananzhuangEntity mangbananzhuang, HttpServletRequest request){
    	mangbananzhuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbananzhuang);
        mangbananzhuangService.insert(mangbananzhuang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MangbananzhuangEntity mangbananzhuang, HttpServletRequest request){
    	mangbananzhuang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbananzhuang);
        mangbananzhuangService.insert(mangbananzhuang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MangbananzhuangEntity mangbananzhuang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mangbananzhuang);
        mangbananzhuangService.updateById(mangbananzhuang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mangbananzhuangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
