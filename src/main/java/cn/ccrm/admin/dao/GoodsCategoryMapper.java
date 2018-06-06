package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.GoodsCategory;

public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
}