package cn.ccrm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import cn.ccrm.admin.entity.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="SELECT * FROM sys_user p WHERE user_id = ?1", nativeQuery=true)
	public User getUserById(int id);
	
	@Query(value="SELECT * FROM sys_user p WHERE username = ?1", nativeQuery=true)
	public User getUserByUserName(String userName);
	
}
