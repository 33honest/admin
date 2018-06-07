package cn.ccrm.admin.web;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.service.IUserService;
import cn.ccrm.admin.web.base.BaseController;

@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/login.htm")
	public String index(ModelMap model) {
		
		return CommonConst.VIEWPREFIX_NAME + "common/login";
	}
	
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ResponseBody
	public Object login() {
		
		return userService.login(this.getParameterMap(), this.getSession());
		
	}
	
	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	public void logout() {
		
		userService.logout(getSession());
		try {
			getResponse().sendRedirect("/login.htm");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
