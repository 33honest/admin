package cn.ccrm.admin.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.service.IGoodsPriceService;
import cn.ccrm.admin.service.IGoodsService;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	
	private String menuUrl = "goods";
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IGoodsPriceService goodsPriceService;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		model.addAttribute("menus", menuService.getAllMenuList());
		
		List<ParameterMap> goodsList = goodsService.getGoodsList(null);
		
		model.addAttribute("goodsList", goodsList);
		
		return CommonConst.VIEWPREFIX_NAME + "goods/index";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model) {
		
		model.addAttribute("menus", menuService.getAllMenuList());
		HashMap<String, Object> goodsInfo = goodsService.queryGoodsInfoById(this.getParameterMap());
		model.addAttribute("goodsInfo", goodsInfo.get("data"));
		
		return CommonConst.VIEWPREFIX_NAME + "goods/edit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Object save() {
		return goodsService.add(this.getParameterMap(), this.getSession());
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public Object del() {
		return goodsService.del(this.getParameterMap());
	}
	
}
