package cn.ccrm.admin.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import cn.ccrm.admin.util.SHA;

public class ShaSecurityPasswordEncoder implements PasswordEncoder {
	
	@Override
	public String encode(CharSequence rawPassword) {

		String pwd = (String) rawPassword;
		try {
			return SHA.encryptSHA(pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		String pwd = (String) rawPassword;
		String md5Pwd = null;
		try {
			md5Pwd = SHA.encryptSHA(pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("rawPassword--->" + rawPassword);
		System.out.println("md5Pwd--->" + md5Pwd);
		System.out.println("encodedPassword--->" + encodedPassword);
		boolean equals = md5Pwd.equals(encodedPassword);
		return equals;
	}
}
