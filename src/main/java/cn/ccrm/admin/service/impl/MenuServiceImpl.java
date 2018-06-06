package cn.ccrm.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccrm.admin.dao.MenuDao;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.Menu;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.service.IMenuService;
import cn.ccrm.admin.util.DateUtil;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.Tools;

@Service
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private MenuDao menuDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public List<Menu> getAllParentMenuList() {
		return menuDao.getAllParentMenu(0);
	}

	@Override
	public List<Menu> getSubMenuListByParentId(long parentId) {
		return menuDao.getSubMenuByParentId(parentId);
	}

	@Override
	public List<Menu> getAllMenuList() {
		List<Menu> allMenu = this.getAllParentMenuList();
		for(Menu m:allMenu){
			List<Menu> subM = this.getSubMenuListByParentId(m.getMENU_ID());
			m.setSubMenu(subM);
		}
		return allMenu;
	}
	
	@Override
	public long getMaxId() {
		return menuDao.getMaxIdByName();
	}
	
	
	@Override
	public Map<String, Object> getSubMenuList(ParameterMap pm) {
		List<Menu> subms = null;
		try {
			long parentId = Integer.parseInt(pm.getString("parent_id"));
			subms = menuDao.getSubMenuByParentId(parentId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("get sub menu error", e);
			return ReturnModel.getModel("error", "falied", new ArrayList<>());
		}
		return ReturnModel.getModel("ok", "success", subms);
	}
	
	@Override
	public Map<String, Object> addMenu(ParameterMap pm,HttpSession session) {
		try {
			System.out.println("pm="+pm);
			long newId = menuDao.getMaxIdByName();
			String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
			pm.put("menu_id", newId+1);
			pm.put("user_id", userId);
			pm.put("create_time", DateUtil.getTime());
			menuDao.saveMenu(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add menu error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
	
	@Override
	public Map<String, Object> delMenu(String menuId) {
		try {
			if(Tools.isEmpty(menuId) || !Tools.isNumber(menuId)){
				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
			}
			menuDao.delMenu(menuId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add menu error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
	
	@Override
	public Map<String, Object> editMenu(ParameterMap pm) {
		try {
			String menuId = pm.getString("menu_id");
			if(Tools.isEmpty(menuId) || !Tools.isNumber(menuId)){
				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
			}
			menuDao.editMenu(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add menu error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
	
	@Override
	public Map<String, Object> findMenu(String menuId) {
		ParameterMap menu = null;
		try {
			if(Tools.isEmpty(menuId) || !Tools.isNumber(menuId)){
				return ReturnModel.getModel("你请求的是一个冒牌接口", "failed", null);
			}
			menu = menuDao.findMenu(menuId);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("add menu error", e);
			return ReturnModel.getModel("error", "falied", null);
		}
		return ReturnModel.getModel("ok", "success", menu);
	}
}
