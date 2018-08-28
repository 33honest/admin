package cn.ccrm.admin.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.ccrm.admin.entity.Role;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.entity.UserRole;
import cn.ccrm.admin.repository.RoleRepository;
import cn.ccrm.admin.repository.UserRepository;
import cn.ccrm.admin.repository.UserRoleRepository;

public class SpringDataUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User userEntity = userRepository.getUserByUserName(username);
		if(null == userEntity) {
			throw new UsernameNotFoundException("User name not found exception + " + username);
		}
		
		UserRole userRoleInfo = userRoleRepository.findUserRoleByUserId(userEntity.getUserId());
		
		Role roleInfo = roleRepository.findById(userRoleInfo.getRole_id()).get();
		
		Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(roleInfo.getRoleName()));
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(username, userEntity.getPassword(), roles);
		System.out.println(userDetails.getAuthorities());
		
		return userDetails;
	}

}
