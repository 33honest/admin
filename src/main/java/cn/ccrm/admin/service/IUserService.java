package cn.ccrm.admin.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.ccrm.admin.util.ParameterMap;

public interface IUserService {
	
	public HashMap<String, Object> login(ParameterMap pm, HttpSession session);
	
	public String logout(HttpSession session);
	
	public List<ParameterMap> getUserList();
	
	public HashMap<String, Object> getRole(ParameterMap pm);
	
	public HashMap<String, Object> saveUser(ParameterMap pm);
	
	public HashMap<String, Object> getUserInfoByUserId(ParameterMap pm);
	
	public HashMap<String, Object> delUser(ParameterMap pm);
	
	
	
}
