package cn.ccrm.admin.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccrm.admin.dao.UserDao;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.enums.StatusCodeEnum;
import cn.ccrm.admin.repository.UserRepository;
import cn.ccrm.admin.service.IUserService;
import cn.ccrm.admin.util.DateUtil;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.SHA;
import cn.ccrm.admin.util.Tools;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public HashMap<String, Object> login(ParameterMap pm, HttpSession session) {
		
		String userName = pm.getString("username");
		String password = pm.getString("password");
		
		if(Tools.isEmpty(userName) ||  Tools.isEmpty(password)) {
			ReturnModel.getModel(StatusCodeEnum.STATUS_4001.getCode(), "fail", StatusCodeEnum.STATUS_4001.getMsg());
		}
		
		
		try {
			password = SHA.encryptSHA(password);
			pm.put("password", password);
			User userInfo = userDao.getUserInfo(pm);
			
			if(null != userInfo) {
				if("lock".equals(userInfo.getStatus())) {
					return ReturnModel.getModel(StatusCodeEnum.STATUS_4003.getCode(), "fail", StatusCodeEnum.STATUS_4003.getMsg());
				}
				int userId = userInfo.getUserId();
				
				session.setAttribute(Const.SESSION_USER, userInfo);
				userDao.saveLoginTime(userId);
				return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("账号[{}]登录错误:{}", userName, e.getMessage());
		}
		
		return ReturnModel.getModel(StatusCodeEnum.STATUS_4004.getCode(), "fail", StatusCodeEnum.STATUS_4004.getMsg());
	}

	@Override
	public String logout(HttpSession session) {
		session.removeAttribute(Const.SESSION_USER);
		return "login";
	}

	@Override
	public List<ParameterMap> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public HashMap<String, Object> getRole(ParameterMap pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> getUserInfoByUserId(ParameterMap pm) {
		try {
			ParameterMap userInfo = userDao.getUserInfoByUserId(pm);
			if(null != userInfo) {
				return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", userInfo);
			}
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4013.getCode(), "fail", StatusCodeEnum.STATUS_4013.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_4014.getCode(), "fail", StatusCodeEnum.STATUS_4014.getMsg());
	}

	@Override
	public HashMap<String, Object> saveUser(ParameterMap pm) {
		
		String userName = pm.getString("username");
		String password = pm.getString("password");
		
		if(Tools.isEmpty(userName)) {
			ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "fail", StatusCodeEnum.STATUS_4005.getMsg());
		}
		
		try {
			if(StringUtils.isNoneBlank(pm.getString("user_id"))) {
				if(StringUtils.isEmpty(password)) {
					pm.remove("psw");
				}else{
					password = SHA.encryptSHA(password);
					pm.put("psw", password);
				}
				userDao.editUser(pm);
			}else{
				password = SHA.encryptSHA(password);
				pm.put("psw", password);
				pm.put("create_time", DateUtil.getTime());
				userDao.saveUser(pm);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4015.getCode(), "failed", StatusCodeEnum.STATUS_4015.getMsg());
		}
		
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
	}

	@Override
	public HashMap<String, Object> delUser(ParameterMap pm) {
		String userId = pm.getString("user_id");
		if(StringUtils.isEmpty(userId)) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "failed", StatusCodeEnum.STATUS_4005.getMsg());
		}
		try {
			userDao.delUser(userId);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4016.getCode(), "failed", StatusCodeEnum.STATUS_4016.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
	}

	@Override
	public User getUserById(Integer id) {
		
		try {
			User user = userRepository.getUserById(id);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
