package cn.ccrm.admin.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.Base64;

import cn.ccrm.admin.config.PropertiesConfig;
import cn.ccrm.admin.dao.GoodsMapper;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.enums.StatusCodeEnum;
import cn.ccrm.admin.service.IGoodsService;
import cn.ccrm.admin.util.DateUtil;
import cn.ccrm.admin.util.ImgUtil;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.Tools;

@Service
public class GoodsServiceImpl implements IGoodsService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private GoodsMapper goodsDao;
	
	@Autowired
	private PropertiesConfig proConfig;

	@Override
	public List<ParameterMap> getGoodsList(ParameterMap pm) {
		return goodsDao.getGoodsList(pm);
	}

	@Override
	public HashMap<String, Object> add(ParameterMap pm, HttpSession session) {

		try {
			String pics = pm.getString("thumb");
			String userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
			if (Tools.notEmpty(pics)) {
				pics = replaceBase64Before(pics);
				byte[] bytes = Base64.base64ToByteArray(pics);
				InputStream in = new ByteArrayInputStream(bytes);
				String filePath = DateUtil.getDays() + Tools.random(8) + ".png";
				String userPath = ImgUtil.uploadImg(proConfig.getUpload(), filePath, in);
				pm.put("thumb", userPath);
			}
			pm.put("admin_id", userId);
			pm.put("create_time", DateUtil.getTime());
			goodsDao.insertSelective(pm);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4010.getCode(), "failed", StatusCodeEnum.STATUS_4010.getMsg());
		}

		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", StatusCodeEnum.STATUS_0000.getMsg());
	}

	@Override
	public HashMap<String, Object> edit(ParameterMap pm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Object> del(ParameterMap pm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 替换base64的前缀
	 * 
	 * @param pics
	 * @return
	 */
	public static String replaceBase64Before(String pics) {
		pics = pics.replace("data:image/png;base64,", "");
		pics = pics.replace("data:image/jpeg;base64,", "");
		pics = pics.replace("data:image/bmp;base64,", "");
		pics = pics.replace("data:image/x-icon;base64,", "");
		pics = pics.replace("data:image/gif;base64,", "");
		return pics;
	}

	@Override
	public HashMap<String, Object> queryGoodsInfoById(ParameterMap pm) {
		
		try {
			ParameterMap selectByPrimaryKey = goodsDao.selectByPrimaryKey(pm);
			return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", selectByPrimaryKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_4011.getCode(), "failed", StatusCodeEnum.STATUS_4011.getMsg());
	}

}
