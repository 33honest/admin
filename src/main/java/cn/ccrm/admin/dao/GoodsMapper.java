package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.entity.Goods;
import cn.ccrm.admin.util.ParameterMap;

public interface GoodsMapper {

	int deleteByPrimaryKey(Integer goodsId);

	int insert(ParameterMap pm);

	int insertSelective(ParameterMap pm);

	public ParameterMap selectByPrimaryKey(ParameterMap pm);

	int updateByPrimaryKeySelective(ParameterMap pm);

	int updateByPrimaryKeyWithBLOBs(ParameterMap pm);

	int updateByPrimaryKey(ParameterMap pm);

	public List<ParameterMap> getGoodsList(ParameterMap pm);
	
	int deleteGoods(ParameterMap pm);
	
	int insertBean(Goods goods);
}