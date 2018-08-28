package cn.ccrm.admin.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.Base64;

import cn.ccrm.admin.config.PropertiesConfig;
import cn.ccrm.admin.dao.AboutSiteMapper;
import cn.ccrm.admin.dao.GoodsMapper;
import cn.ccrm.admin.dao.GoodsPriceMapper;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.Goods;
import cn.ccrm.admin.entity.GoodsPrice;
import cn.ccrm.admin.entity.ReturnModel;
import cn.ccrm.admin.entity.User;
import cn.ccrm.admin.enums.StatusCodeEnum;
import cn.ccrm.admin.service.IArticleService;
import cn.ccrm.admin.service.IGoodsService;
import cn.ccrm.admin.util.DateUtil;
import cn.ccrm.admin.util.ImgUtil;
import cn.ccrm.admin.util.ParameterMap;
import cn.ccrm.admin.util.Tools;

@Service
public class ArticleServiceImpl implements IArticleService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AboutSiteMapper siteDao;

	@Autowired
	private PropertiesConfig proConfig;

	@Override
	public List<ParameterMap> getArticleList(ParameterMap pm) {
		return siteDao.getArticleList(pm);
	}

	@Override
	public HashMap<String, Object> add(ParameterMap pm, HttpSession session) {
		try {
			String pics = pm.getString("thumb");
			int userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
			if (Tools.notEmpty(pics)) {
				if (pics.indexOf("ta:image") > 0) {
					pics = replaceBase64Before(pics);
					byte[] bytes = Base64.base64ToByteArray(pics);
					InputStream in = new ByteArrayInputStream(bytes);
					String filePath = DateUtil.getDays() + Tools.random(8) + ".png";
					String userPath = ImgUtil.uploadImg(proConfig.getUpload(), filePath, in);
					pm.put("thumb", userPath);
				} else {
					pm.remove("thumb");
				}
			}
			String id = pm.getString("id");
			pm.put("user_id", userId);
			if (StringUtils.isNoneBlank(id)) {
				pm.put("update_time", DateUtil.getTime());
				siteDao.updateByPrimaryKeyWithBLOBs(pm);
			} else {
				pm.remove("id");
				pm.put("create_time", DateUtil.getTime());
				siteDao.saveArticle(pm);
			}

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
		if(StringUtils.isBlank(pm.getString("id"))) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "failed", StatusCodeEnum.STATUS_4005.getMsg());
		}
		
		List<String> id = new ArrayList<>();
		if(pm.getString("id").indexOf(",") > 0) {
			String[] idArr = pm.getString("id").split(",");
			id = Arrays.asList(idArr);
		}else{
			id.add(pm.getString("id"));
		}
		pm.put("id", id);
		try {
			siteDao.deleteArticle(pm);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4012.getCode(), "failed", StatusCodeEnum.STATUS_4012.getMsg());
		}
		
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", StatusCodeEnum.STATUS_0000.getMsg());
	}

	@Override
	public HashMap<String, Object> queryArticleInfoById(ParameterMap pm) {
		try {
			ParameterMap selectByPrimaryKey = siteDao.selectByPrimaryKey(pm);
			return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", selectByPrimaryKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ReturnModel.getModel(StatusCodeEnum.STATUS_4011.getCode(), "failed", StatusCodeEnum.STATUS_4011.getMsg());
	}
	
	public static String replaceBase64Before(String pics) {
		pics = pics.replace("data:image/png;base64,", "");
		pics = pics.replace("data:image/jpeg;base64,", "");
		pics = pics.replace("data:image/bmp;base64,", "");
		pics = pics.replace("data:image/x-icon;base64,", "");
		pics = pics.replace("data:image/gif;base64,", "");
		return pics;
	}

}
