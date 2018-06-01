package cn.ccrm.admin.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccrm.admin.common.CommonConst;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	private String menuUrl = "goods";
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		return CommonConst.VIEWPREFIX_NAME + "goods/index";
	}
	
}
