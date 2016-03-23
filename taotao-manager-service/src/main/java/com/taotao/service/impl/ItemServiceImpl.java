package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	
	public TbItem getItemById(long id) {
		return itemMapper.selectByPrimaryKey(id); 
	}

	public EUDataGridResult getItemList(int page, int rows) {
		//查询商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> items = itemMapper.selectByExample(example);
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(items);
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(items);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

}
