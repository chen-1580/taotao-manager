package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

@Controller
public class TestPageHelper {

	@Test
	public void testPageHelper(){
		// 创建spring容器
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		// 从spring容器中获得Mapper对象
		TbItemMapper mapper = ctx.getBean(TbItemMapper.class);
		// 执行分页查询
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(2, 10);
		List<TbItem> items = mapper.selectByExample(example);
		
		for (TbItem item : items) {
			System.out.println(item.getTitle());
		}
		//获取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(items);
		System.out.println("共有商品：" + pageInfo.getTotal());
	}
}
