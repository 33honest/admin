package cn.ccrm.admin.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		return CommonConst.VIEWPREFIX_NAME + "common/login";
	}
	
	@RequestMapping("/login")
	public void login() {
		
		HttpServletRequest request = getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String authcode = request.getParameter("authcode");
		
		
	}
	
}
