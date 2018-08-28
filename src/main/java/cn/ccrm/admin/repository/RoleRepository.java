package cn.ccrm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.ccrm.admin.entity.Role;

@Component
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
