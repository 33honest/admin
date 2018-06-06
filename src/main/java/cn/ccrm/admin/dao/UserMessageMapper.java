package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.UserMessage;

public interface UserMessageMapper {
    int deleteByPrimaryKey(Integer userMessageId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    UserMessage selectByPrimaryKey(Integer userMessageId);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}