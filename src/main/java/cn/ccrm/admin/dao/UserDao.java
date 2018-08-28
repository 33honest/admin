package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.entity.Role;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.util.ParameterMap;

public interface UserDao {
	public User getUserInfo(ParameterMap pm);
	public List<Role> getUserRoleList(ParameterMap pm);
	public List<ParameterMap> getUserList();
	public void saveLoginTime(int userId);
	public void saveUser(ParameterMap pm);
	public void bathSaveUserRole(List<ParameterMap> parame);
	public void editUser(ParameterMap pm);
	public void delUser(String userId);
	public void delUserRole(String userId);
	public ParameterMap getUserInfoByUserId(ParameterMap pm);
}
