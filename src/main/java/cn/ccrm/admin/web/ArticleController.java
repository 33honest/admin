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
import cn.ccrm.admin.service.IArticleService;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private IArticleService articleService;
	
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
		List<ParameterMap> articleList = articleService.getArticleList(this.getParameterMap());
		PageInfo pageInfo = new PageInfo<>(articleList);
		System.out.println(pageInfo);
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("keywords", keywords);
		model.addAttribute("category_id", category_id);
		
		return CommonConst.VIEWPREFIX_NAME + "article/index";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model) {
		
		model.addAttribute("menus", menuService.getAllMenuList());
		HashMap<String, Object> goodsInfo = articleService.queryArticleInfoById(this.getParameterMap());
		model.addAttribute("article", goodsInfo.get("data"));
		
		return CommonConst.VIEWPREFIX_NAME + "article/edit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public Object save() {
		return articleService.add(this.getParameterMap(), this.getSession());
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public Object del() {
		return articleService.del(this.getParameterMap());
	}
	
}
