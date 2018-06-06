package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.UserPayment;

public interface UserPaymentMapper {
	int deleteByPrimaryKey(Integer userPaymentId);

	int insert(UserPayment record);

	int insertSelective(UserPayment record);

	UserPayment selectByPrimaryKey(Integer userPaymentId);

	int updateByPrimaryKeySelective(UserPayment record);

	int updateByPrimaryKey(UserPayment record);
}