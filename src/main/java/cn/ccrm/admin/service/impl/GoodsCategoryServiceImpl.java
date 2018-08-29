package cn.ccrm.admin.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import cn.ccrm.admin.dao.GoodsCategoryMapper;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.GoodsCategory;
import cn.ccrm.admin.entity.Menu;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.enums.StatusCodeEnum;
import cn.ccrm.admin.service.IGoodsCategory;
import cn.ccrm.admin.util.DateUtil;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.Tools;

@Service
public class GoodsCategoryServiceImpl implements IGoodsCategory{

	@Autowired
	private GoodsCategoryMapper menuDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<GoodsCategory> getAllMenuList() {
		List<GoodsCategory> allMenu = this.getAllParentMenuList();
		for(GoodsCategory m:allMenu){
			List<GoodsCategory> subM = this.getSubMenuListByParentId(m.getCategoryId());
			m.setSubMenu(subM);
		}
		return allMenu;
	}

	@Override
	public List<GoodsCategory> getAllParentMenuList() {
		return menuDao.getAllParentMenu(0);
	}

	@Override
	public List<GoodsCategory> getSubMenuListByParentId(long parentId) {
		return menuDao.getSubMenuByParentId(parentId);
	}

	@Override
	public long getMaxId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSubMenuList(ParameterMap pm) {
		List<GoodsCategory> subms = null;
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
	public Map<String, Object> addMenu(ParameterMap pm, HttpSession session) {
		try {
			long newId = 0;
			try {
				newId = menuDao.getMaxIdByName();
			} catch (Exception e) {}
			
			UserDetails  userDetails  = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			//int userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
			pm.put("category_id", newId+1);
			//pm.put("admin_id", 11);
			pm.put("create_time", DateUtil.getTime());
			pm.put("state", 1);
			menuDao.insert(pm);
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4008.getCode(), "failed", StatusCodeEnum.STATUS_4008.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
	}

	@Override
	public Map<String, Object> delMenu(String menuId) {
		try {
			if(Tools.isEmpty(menuId) || !Tools.isNumber(menuId)){
				return ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "failed", StatusCodeEnum.STATUS_4005.getMsg());
			}
			menuDao.delMenu(menuId);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4009.getCode(), "failed", StatusCodeEnum.STATUS_4009.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
	}

	@Override
	public Map<String, Object> editMenu(ParameterMap pm, HttpSession session) {
		try {
			String menuId = pm.getString("category_id");
			if(Tools.isEmpty(menuId)){
				this.addMenu(pm, session);
			}else{
				pm.put("update_time", DateUtil.getTime());
				menuDao.editMenu(pm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4007.getCode(), "failed", StatusCodeEnum.STATUS_4007.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", null);
	}

	@Override
	public Map<String, Object> findMenu(String menuId) {
		ParameterMap menu = null;
		try {
			if(Tools.isEmpty(menuId) || !Tools.isNumber(menuId)){
				return ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "failed", StatusCodeEnum.STATUS_4005.getMsg());
			}
			menu = menuDao.findMenu(menuId);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4006.getCode(), "failed", StatusCodeEnum.STATUS_4006.getMsg());
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", menu);
	}
	
}
