package cn.ccrm.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import cn.ccrm.admin.service.IUserService;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.Tools;
import cn.ccrm.admin.web.base.BaseController;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private String menuUrl = "user/index";

	@Autowired
	private IUserService userService;

	@RequestMapping("/index")
	public String index(ModelMap model) {

		List<ParameterMap> userList = userService.getUserList();
		model.addAttribute("userList", userList);

		return CommonConst.VIEWPREFIX_NAME + "user/index";
	}

	@RequestMapping("/edit")
	public String edit(ModelMap model) {

		Map<String, Object> userInfo = new HashMap<>();
		String userId = this.getRequest().getParameter("user_id");
		if (StringUtils.isNoneBlank(userId)) {
			Map<String, Object> userResult = userService.getUserInfoByUserId(this.getParameterMap());
			if (userResult.get("msg").equals("0000")) {
				userInfo = (Map<String, Object>) userResult.get("data");
			}
		}
		model.addAttribute("userInfo", userInfo);

		return CommonConst.VIEWPREFIX_NAME + "user/edit";
	}

	@RequestMapping("/save")
	@ResponseBody
	public Object save() {

		return userService.saveUser(getParameterMap());
	}

	@RequestMapping("/del")
	@ResponseBody
	public Object del() {
		return userService.delUser(this.getParameterMap());
	}

}
