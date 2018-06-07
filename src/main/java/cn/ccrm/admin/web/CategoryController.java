package cn.ccrm.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.entity.Menu;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
	
	private String menuUrl = "category/index";
	
	@Autowired
	private IMenuService menuService;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		List<Menu> allMenuList = menuService.getAllMenuList();
		model.addAttribute("menus", allMenuList);
		
		return CommonConst.VIEWPREFIX_NAME + "category/index";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model) {
		
		List<Menu> menuList = menuService.getAllParentMenuList();
		model.addAttribute("menus", menuList);
		
		return CommonConst.VIEWPREFIX_NAME + "category/edit";
	}
	
	@RequestMapping("/getSubMenu")
	@ResponseBody
	public Object getSubMenu() {
		
		return menuService.getSubMenuList(this.getParameterMap());
	}
	
}
