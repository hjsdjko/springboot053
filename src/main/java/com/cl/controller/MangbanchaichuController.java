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

import com.cl.entity.MangbanchaichuEntity;
import com.cl.entity.view.MangbanchaichuView;

import com.cl.service.MangbanchaichuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 盲板拆除
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-29 10:05:00
 */
@RestController
@RequestMapping("/mangbanchaichu")
public class MangbanchaichuController {
    @Autowired
    private MangbanchaichuService mangbanchaichuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MangbanchaichuEntity mangbanchaichu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mangbanchaichu.setChaichurenzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MangbanchaichuEntity> ew = new EntityWrapper<MangbanchaichuEntity>();

		PageUtils page = mangbanchaichuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanchaichu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MangbanchaichuEntity mangbanchaichu, 
		HttpServletRequest request){
        EntityWrapper<MangbanchaichuEntity> ew = new EntityWrapper<MangbanchaichuEntity>();

		PageUtils page = mangbanchaichuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mangbanchaichu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MangbanchaichuEntity mangbanchaichu){
       	EntityWrapper<MangbanchaichuEntity> ew = new EntityWrapper<MangbanchaichuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mangbanchaichu, "mangbanchaichu")); 
        return R.ok().put("data", mangbanchaichuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MangbanchaichuEntity mangbanchaichu){
        EntityWrapper< MangbanchaichuEntity> ew = new EntityWrapper< MangbanchaichuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mangbanchaichu, "mangbanchaichu")); 
		MangbanchaichuView mangbanchaichuView =  mangbanchaichuService.selectView(ew);
		return R.ok("查询盲板拆除成功").put("data", mangbanchaichuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MangbanchaichuEntity mangbanchaichu = mangbanchaichuService.selectById(id);
		mangbanchaichu = mangbanchaichuService.selectView(new EntityWrapper<MangbanchaichuEntity>().eq("id", id));
        return R.ok().put("data", mangbanchaichu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MangbanchaichuEntity mangbanchaichu = mangbanchaichuService.selectById(id);
		mangbanchaichu = mangbanchaichuService.selectView(new EntityWrapper<MangbanchaichuEntity>().eq("id", id));
        return R.ok().put("data", mangbanchaichu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MangbanchaichuEntity mangbanchaichu, HttpServletRequest request){
    	mangbanchaichu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanchaichu);
        mangbanchaichuService.insert(mangbanchaichu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MangbanchaichuEntity mangbanchaichu, HttpServletRequest request){
    	mangbanchaichu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mangbanchaichu);
        mangbanchaichuService.insert(mangbanchaichu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody MangbanchaichuEntity mangbanchaichu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mangbanchaichu);
        mangbanchaichuService.updateById(mangbanchaichu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<MangbanchaichuEntity> list = new ArrayList<MangbanchaichuEntity>();
        for(Long id : ids) {
            MangbanchaichuEntity mangbanchaichu = mangbanchaichuService.selectById(id);
            mangbanchaichu.setSfsh(sfsh);
            mangbanchaichu.setShhf(shhf);
            list.add(mangbanchaichu);
        }
        mangbanchaichuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mangbanchaichuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
