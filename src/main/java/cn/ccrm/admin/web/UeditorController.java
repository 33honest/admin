package cn.ccrm.admin.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.ccrm.admin.common.ueditor.ActionEnter;

@RestController
@CrossOrigin
@RequestMapping("/ueditor")
public class UeditorController {

	@RequestMapping(value = "/exec")
	@ResponseBody
	public String exec(HttpServletRequest request) throws UnsupportedEncodingException, JSONException{ 
		request.setCharacterEncoding("utf-8");
		String rootPath = request.getRealPath("/");
		return new ActionEnter( request, rootPath ).exec();
	}
	
}
