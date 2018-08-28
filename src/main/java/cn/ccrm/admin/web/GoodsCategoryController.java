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
import cn.ccrm.admin.entity.GoodsCategory;
import cn.ccrm.admin.service.IGoodsCategory;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/admin/goodscategory")
public class GoodsCategoryController extends BaseController {
	
	private String menuUrl = "goodscategory/index";
	
	@Autowired
	private IGoodsCategory menuService;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		List<GoodsCategory> allMenuList = menuService.getAllMenuList();
		model.addAttribute("menus", allMenuList);
		
		return CommonConst.VIEWPREFIX_NAME + "goodscategory/index";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model) {
		
		List<GoodsCategory> menuList = menuService.getAllParentMenuList();
		model.addAttribute("menus", menuList);
		Map<String, Object> menu = new HashMap<>();
		String menuId = this.getRequest().getParameter("category_id");
		if(StringUtils.isNoneBlank(menuId)) {
			Map<String, Object> findMenuRest = menuService.findMenu(menuId);
			if(findMenuRest.get("msg").equals("0000")) {
				menu = (Map<String, Object>) findMenuRest.get("data");
			}
		}
		model.addAttribute("menuDetail", menu);
		
		return CommonConst.VIEWPREFIX_NAME + "goodscategory/edit";
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
