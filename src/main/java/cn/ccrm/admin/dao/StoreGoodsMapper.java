package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.StoreGoods;

public interface StoreGoodsMapper {
    int deleteByPrimaryKey(Integer storeId);

    int insert(StoreGoods record);

    int insertSelective(StoreGoods record);

    StoreGoods selectByPrimaryKey(Integer storeId);

    int updateByPrimaryKeySelective(StoreGoods record);

    int updateByPrimaryKey(StoreGoods record);
}