package cn.ccrm.admin.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.ccrm.admin.util.ParameterMap;

public interface IArticleService {
	
	public List<ParameterMap> getArticleList(ParameterMap pm);

	public HashMap<String, Object> add(ParameterMap pm, HttpSession session);

	public HashMap<String, Object> edit(ParameterMap pm);

	public HashMap<String, Object> del(ParameterMap pm);
	
	public HashMap<String, Object> queryArticleInfoById(ParameterMap pm);
}
