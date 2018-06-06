package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.PaymentMethod;
import cn.ccrm.admin.entity.PaymentMethodKey;

public interface PaymentMethodMapper {
    int deleteByPrimaryKey(PaymentMethodKey key);

    int insert(PaymentMethod record);

    int insertSelective(PaymentMethod record);

    PaymentMethod selectByPrimaryKey(PaymentMethodKey key);

    int updateByPrimaryKeySelective(PaymentMethod record);

    int updateByPrimaryKey(PaymentMethod record);
}