package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemServiceById(@PathVariable Long itemId){
		return itemService.getItemById(itemId);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page,Integer rows){
		return itemService.getItemList(page, rows);
	}
}
