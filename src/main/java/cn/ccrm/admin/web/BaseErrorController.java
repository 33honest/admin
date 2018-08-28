package cn.ccrm.admin.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ccrm.admin.common.CommonConst;

@Controller
@RequestMapping("error")
public class BaseErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return CommonConst.VIEWPREFIX_NAME + "authenticated/fail";
	}

	@RequestMapping
	public String error() {
		
		return getErrorPath();
	}

}
