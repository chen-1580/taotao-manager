package com.taotao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/list")
	@ResponseBody
	// 如果id为null是使用默认值，也就是parentid为0的分类列表
	public List<EUTreeNode> categoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) throws Exception {
		List<EUTreeNode> catList = new ArrayList();
		// 查询数据库
		List<TbItemCat> itemCats = itemCatService.getItemCatList(parentId);
		for (TbItemCat itemCat : itemCats) {
			EUTreeNode node = new EUTreeNode();
			node.setId(itemCat.getId());
			node.setText(itemCat.getName());
			// 如果是父节点的话就设置成关闭状态，如果是叶子节点就是open状态
			node.setState(itemCat.getIsParent() ? "closed" : "open");
			catList.add(node);
		}
		return catList;
	}

}
