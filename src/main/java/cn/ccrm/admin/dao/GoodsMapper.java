package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.entity.Goods;
import cn.ccrm.admin.util.ParameterMap;

public interface GoodsMapper {
	
	int deleteByPrimaryKey(Integer goodsId);

	int insert(ParameterMap pm);

	int insertSelective(ParameterMap pm);

	public ParameterMap selectByPrimaryKey(ParameterMap pm);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKeyWithBLOBs(Goods record);

	int updateByPrimaryKey(Goods record);
	
	public List<ParameterMap> getGoodsList(ParameterMap pm);
}