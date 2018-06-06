package cn.ccrm.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccrm.admin.dao.UserDao;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.enums.StatusCodeEnum;
import cn.ccrm.admin.service.IUserService;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.SHA;
import cn.ccrm.admin.util.Tools;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public HashMap<String, Object> login(ParameterMap pm, HttpSession session) {
		
		String userName = pm.getString("username");
		String password = pm.getString("password");
		
		if(Tools.isEmpty(userName) ||  Tools.isEmpty(password)) {
			ReturnModel.getModel(StatusCodeEnum.STATUS_4001.getCode(), "fail", null);
		}
		
		
		try {
			password = SHA.encryptSHA(password);
			pm.put("password", password);
			User userInfo = userDao.getUserInfo(pm);
			
			if(null != userInfo) {
				if("lock".equals(userInfo.getStatus())) {
					return ReturnModel.getModel(StatusCodeEnum.STATUS_4003.getCode(), "fail", null);
				}
				String userId = userInfo.getUserId();
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("账号登录错误:{}", e.getMessage());
		}
		
		return ReturnModel.getModel(StatusCodeEnum.STATUS_4004.getCode(), "fail", null);
	}

	@Override
	public String logout(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParameterMap> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> getRole(ParameterMap pm) {
		// TODO Auto-generated method stub
		return null;
	}

}
