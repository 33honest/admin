package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.GoodsPrice;

public interface GoodsPriceMapper {
    int deleteByPrimaryKey(Integer priceId);

    int insert(GoodsPrice record);

    int insertSelective(GoodsPrice record);

    GoodsPrice selectByPrimaryKey(Integer priceId);

    int updateByPrimaryKeySelective(GoodsPrice record);

    int updateByPrimaryKey(GoodsPrice record);
}