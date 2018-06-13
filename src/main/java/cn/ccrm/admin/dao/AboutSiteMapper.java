package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.entity.AboutSite;
import cn.ccrm.admin.util.ParameterMap;

public interface AboutSiteMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(AboutSite record);

	int insertSelective(AboutSite record);

	ParameterMap selectByPrimaryKey(ParameterMap pm);

	int updateByPrimaryKeySelective(AboutSite record);

	int updateByPrimaryKeyWithBLOBs(ParameterMap pm);

	int updateByPrimaryKey(AboutSite record);
	
	public List<ParameterMap> getArticleList(ParameterMap pm);
	
	public int saveArticle(ParameterMap pm);
	
	int deleteArticle(ParameterMap pm);
	
}