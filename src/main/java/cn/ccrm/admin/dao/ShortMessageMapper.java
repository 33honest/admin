package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.ShortMessage;

public interface ShortMessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(ShortMessage record);

    int insertSelective(ShortMessage record);

    ShortMessage selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(ShortMessage record);

    int updateByPrimaryKey(ShortMessage record);
}