package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.OrderJoin;

public interface OrderJoinMapper {
    int deleteByPrimaryKey(Integer joinOrderId);

    int insert(OrderJoin record);

    int insertSelective(OrderJoin record);

    OrderJoin selectByPrimaryKey(Integer joinOrderId);

    int updateByPrimaryKeySelective(OrderJoin record);

    int updateByPrimaryKeyWithBLOBs(OrderJoin record);

    int updateByPrimaryKey(OrderJoin record);
}