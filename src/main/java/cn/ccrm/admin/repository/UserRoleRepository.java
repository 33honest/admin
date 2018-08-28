package cn.ccrm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import cn.ccrm.admin.entity.UserRole;

@Component
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	
	@Query(value="SELECT * FROM `sys_user_role` WHERE user_id = ?1", nativeQuery=true)
	public UserRole findUserRoleByUserId(int userId);
	
}
