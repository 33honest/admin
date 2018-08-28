package cn.ccrm.admin.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ccrm.admin.web.base.BaseController;

@RestController

@RequestMapping(value="/home")
public class HomeController extends BaseController {
	
	@RequestMapping("/hello")
	public String hello(){
		
		return "hello admin system";
	}
	
	@RequestMapping("/role")
	public String role(){
		
		return "hello role";
	}
	
	@RequestMapping("/roleadmin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String roleadmin(){
		
		return "hello roleadmin";
	}
	
}
