package cn.ccrm.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ccrm.admin.common.CommonConst;
import cn.ccrm.admin.service.IUserService;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	public String index(ModelMap model) {
		
		return CommonConst.VIEWPREFIX_NAME + "common/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login() {
		
		userService.login(this.getParameterMap(), this.getSession());
		
	}
	
}
