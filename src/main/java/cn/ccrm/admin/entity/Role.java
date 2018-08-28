package cn.ccrm.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class Role {

	@Id
	@Column(name = "role_id")
	private int roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_desc")
	private String roleDesc;
	private String rights;
	private String addQX;
	private String delQX;
	private String editQX;
	private String queryQX;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getAddQX() {
		return addQX;
	}

	public void setAddQX(String addQX) {
		this.addQX = addQX;
	}

	public String getDelQX() {
		return delQX;
	}

	public void setDelQX(String delQX) {
		this.delQX = delQX;
	}

	public String getEditQX() {
		return editQX;
	}

	public void setEditQX(String editQX) {
		this.editQX = editQX;
	}

	public String getQueryQX() {
		return queryQX;
	}

	public void setQueryQX(String queryQX) {
		this.queryQX = queryQX;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + ", rights=" + rights + ", addQX=" + addQX + ", delQX=" + delQX + ", editQX=" + editQX + ", queryQX=" + queryQX + "]";
	}

}
