package cn.ccrm.admin.dao;

import cn.ccrm.admin.entity.AboutSite;

public interface AboutSiteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AboutSite record);

    int insertSelective(AboutSite record);

    AboutSite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AboutSite record);

    int updateByPrimaryKeyWithBLOBs(AboutSite record);

    int updateByPrimaryKey(AboutSite record);
}