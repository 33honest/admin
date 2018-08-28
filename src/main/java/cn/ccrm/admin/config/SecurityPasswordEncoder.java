package cn.ccrm.admin.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

public class SecurityPasswordEncoder  implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		
		String pwd = (String) rawPassword;
		return DigestUtils.md5DigestAsHex(pwd.getBytes());
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		String pwd = (String) rawPassword;
		String md5Pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
		System.out.println("rawPassword--->" + rawPassword);
		System.out.println("md5Pwd--->" + md5Pwd);
		System.out.println("encodedPassword--->" + encodedPassword);
		boolean equals = md5Pwd.equals(encodedPassword);
		return equals;
	}

}
