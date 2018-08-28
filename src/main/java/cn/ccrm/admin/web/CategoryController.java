package cn.ccrm.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.entity.Menu;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.util.Tools;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/admin/category")
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
		Map<String, Object> menu = new HashMap<>();
		String menuId = this.getRequest().getParameter("menu_id");
		if(StringUtils.isNoneBlank(menuId)) {
			Map<String, Object> findMenuRest = menuService.findMenu(menuId);
			if(findMenuRest.get("msg").equals("0000")) {
				menu = (Map<String, Object>) findMenuRest.get("data");
			}
		}
		System.out.println(menu);
		model.addAttribute("menuDetail", menu);
		
		return CommonConst.VIEWPREFIX_NAME + "category/edit";
	}
	
	@RequestMapping("/getSubMenu")
	@ResponseBody
	public Object getSubMenu() {
		
		return menuService.getSubMenuList(this.getParameterMap());
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Object save() {
		
		return menuService.editMenu(getParameterMap(), this.getSession());
	}
	
	@RequestMapping("/del/{menu_id}")
	@ResponseBody
	public Object del(@PathVariable("menu_id") String menuId) {
		
		return menuService.delMenu(menuId);
	}
	
}
