package cn.ccrm.admin.web;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.service.IGoodsCategory;
import cn.ccrm.admin.service.IGoodsPriceService;
import cn.ccrm.admin.service.IGoodsService;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/admin/goods")
public class GoodsController extends BaseController {
	
	private String menuUrl = "goods";
	
	@Autowired
	private IGoodsCategory menuService;
	
	@Autowired
	private IGoodsService goodsService;
	
	@Autowired
	private IGoodsPriceService goodsPriceService;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		HttpServletRequest request = this.getRequest();
		model.addAttribute("menus", menuService.getAllMenuList());
		int pageNum = request.getParameter("pageNum") == null ? 1 : Integer.valueOf(request.getParameter("pageNum"));
		String keywords = "";
		String category_id = "";
		if(StringUtils.isNotBlank(request.getParameter("keywords"))) {
			keywords = request.getParameter("keywords");
		}
		if(StringUtils.isNotBlank(request.getParameter("category_id"))) {
			category_id = request.getParameter("category_id");
		}
		
		PageHelper.startPage(pageNum , CommonConst.PAGE_SIZE);
		List<ParameterMap> goodsList = goodsService.getGoodsList(this.getParameterMap());
		PageInfo pageInfo = new PageInfo<>(goodsList);
		System.out.println(pageInfo);
		
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("keywords", keywords);
		model.addAttribute("category_id", category_id);
		
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
