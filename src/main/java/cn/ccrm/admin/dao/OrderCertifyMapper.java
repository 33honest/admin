package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.OrderCertify;

public interface OrderCertifyMapper {
    int deleteByPrimaryKey(Integer certifyId);

    int insert(OrderCertify record);

    int insertSelective(OrderCertify record);

    OrderCertify selectByPrimaryKey(Integer certifyId);

    int updateByPrimaryKeySelective(OrderCertify record);

    int updateByPrimaryKey(OrderCertify record);
}