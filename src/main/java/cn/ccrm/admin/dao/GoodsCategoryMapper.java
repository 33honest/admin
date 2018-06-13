package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.entity.GoodsCategory;
import cn.ccrm.admin.entity.Menu;
import cn.ccrm.admin.util.ParameterMap;

public interface GoodsCategoryMapper {

	int deleteByPrimaryKey(Integer categoryId);

	int insert(ParameterMap pm);

	int insertSelective(ParameterMap pm);

	GoodsCategory selectByPrimaryKey(Integer categoryId);

	int updateByPrimaryKeySelective(ParameterMap pm);

	int updateByPrimaryKey(ParameterMap pm);

	public List<GoodsCategory> getAllParentMenu(Object obj);

	public List<GoodsCategory> getSubMenuByParentId(long ParentId);

	public long getMaxIdByName();

	public void saveMenu(ParameterMap pm);

	public void delMenu(String menuId);

	public void editMenu(ParameterMap pm);

	public ParameterMap findMenu(String menuId);
	

}