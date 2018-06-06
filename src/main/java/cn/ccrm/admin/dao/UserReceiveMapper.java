package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.UserReceive;

public interface UserReceiveMapper {
    int deleteByPrimaryKey(Integer receiveId);

    int insert(UserReceive record);

    int insertSelective(UserReceive record);

    UserReceive selectByPrimaryKey(Integer receiveId);

    int updateByPrimaryKeySelective(UserReceive record);

    int updateByPrimaryKey(UserReceive record);
}