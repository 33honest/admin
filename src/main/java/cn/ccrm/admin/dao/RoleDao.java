package cn.ccrm.admin.dao;

import java.util.List;

import cn.ccrm.admin.util.ParameterMap;

public interface RoleDao {
	public List<ParameterMap> list();
	public List<ParameterMap> getRoleByuId(ParameterMap pm);
	public ParameterMap getRoleById(ParameterMap pm);
	public void updateRoleQX(ParameterMap pm);
	public void addRole(ParameterMap pm);
	public void delRole(String roleId);
	public void delUserRole(String roleId);
}
