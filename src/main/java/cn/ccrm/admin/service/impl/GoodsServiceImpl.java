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
import cn.ccrm.admin.dao.GoodsMapper;
import cn.ccrm.admin.dao.GoodsPriceMapper;
import cn.ccrm.admin.entity.Const;
import cn.ccrm.admin.entity.Goods;
import cn.ccrm.admin.entity.GoodsPrice;
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
	
	@Autowired
	private GoodsPriceMapper goodsPriceDao;

	@Override
	public List<ParameterMap> getGoodsList(ParameterMap pm) {
		return goodsDao.getGoodsList(pm);
	}

	@Override
	public HashMap<String, Object> add(ParameterMap pm, HttpSession session) {

		try {
			String pics = pm.getString("thumb");
			int userId = ((User) session.getAttribute(Const.SESSION_USER)).getUserId();
			if (Tools.notEmpty(pics)) {
				if(pics.indexOf("ta:image") > 0) {
					pics = replaceBase64Before(pics);
					byte[] bytes = Base64.base64ToByteArray(pics);
					InputStream in = new ByteArrayInputStream(bytes);
					String filePath = DateUtil.getDays() + Tools.random(8) + ".png";
					String userPath = ImgUtil.uploadImg(proConfig.getUpload(), filePath, in);
					pm.put("thumb", userPath);
				}else{
					pm.remove("thumb");
				}
			}
			String goodsId = pm.getString("goods_id");
			pm.put("admin_id", userId);
			if(StringUtils.isNoneBlank(goodsId)) {
				pm.put("update_time", DateUtil.getTime());
				goodsDao.updateByPrimaryKeySelective(pm);
				
				GoodsPrice record = this.mapToGoodsPrice(pm);
				goodsPriceDao.updateByPrimaryKeySelective(record);
			}else{
				
				Goods goods = this.mapToGoods(pm);
				goods.setCreateTime(new Date());
				goodsDao.insertBean(goods);
				int goods_id = goods.getGoodsId();
				pm.put("goods_id", goods_id);
				GoodsPrice record = this.mapToGoodsPrice(pm);
				record.setCreateTime(new Date());
				goodsPriceDao.insert(record);
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
		
		if(StringUtils.isBlank(pm.getString("goods_id"))) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4005.getCode(), "failed", StatusCodeEnum.STATUS_4005.getMsg());
		}
		
		List<String> goods_id = new ArrayList<>();
		if(pm.getString("goods_id").indexOf(",") > 0) {
			String[] goodsArr = pm.getString("goods_id").split(",");
			goods_id = Arrays.asList(goodsArr);
		}else{
			goods_id.add(pm.getString("goods_id"));
		}
		pm.put("goods_id", goods_id);
		try {
			goodsDao.deleteGoods(pm);
		} catch (Exception e) {
			return ReturnModel.getModel(StatusCodeEnum.STATUS_4012.getCode(), "failed", StatusCodeEnum.STATUS_4012.getMsg());
		}
		
		return ReturnModel.getModel(StatusCodeEnum.STATUS_0000.getCode(), "success", StatusCodeEnum.STATUS_0000.getMsg());
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
	
	private ParameterMap goodsPriceToMap(GoodsPrice gp) {
		
		ParameterMap pm = new ParameterMap();
		
		if(null != gp.getAdminId()) {
			pm.put("admin_id", gp.getAdminId());
		}
		if(null != gp.getBuyPrice()) {
			pm.put("buy_price", gp.getBuyPrice());
		}
		if(null != gp.getGoodsId()) {
			pm.put("goods_id", gp.getGoodsId());
		}
		if(null != gp.getRetailPrice()) {
			pm.put("retail_price", gp.getRetailPrice());
		}
		if(null != gp.getState()) {
			pm.put("state", gp.getState());
		}
		if(null != gp.getUnitName()) {
			pm.put("unit_name", gp.getUnitName());
		}
		if(null != gp.getWholesalePrice()) {
			pm.put("wholesale_price", gp.getWholesalePrice());
		}
		if(null != gp.getCreateTime()) {
			pm.put("create_time", gp.getCreateTime());
		}
		if(null != gp.getUpdateTime()) {
			pm.put("update_time", gp.getUpdateTime());
		}
		
		return pm;
	}
	
	private GoodsPrice mapToGoodsPrice(ParameterMap pm) {
		GoodsPrice gp = new GoodsPrice();
		
		if(pm.containsKey("admin_id")) {
			gp.setAdminId(Integer.valueOf(pm.getString("admin_id")));
		}
		if(pm.containsKey("buy_price")) {
			gp.setBuyPrice(Integer.valueOf(pm.getString("buy_price")));
		}
		if(pm.containsKey("goods_id")) {
			gp.setGoodsId(Integer.valueOf(pm.getString("goods_id")));
		}
		if(pm.containsKey("retail_price")) {
			gp.setRetailPrice(Integer.valueOf(pm.getString("retail_price")));
		}
		if(pm.containsKey("state")) {
			gp.setState(Byte.valueOf(pm.getString("state")));
		}
		if(pm.containsKey("unit_name")) {
			gp.setUnitName(pm.getString("unit_name"));
		}
		if(pm.containsKey("wholesale_price")) {
			gp.setWholesalePrice(Integer.valueOf(pm.getString("wholesale_price")));
		}
		
		return gp;
	}
	
	/**
	 * HashMap对象转换成Goods对象
	 * @param pm
	 * @return
	 */
	private Goods mapToGoods(ParameterMap pm) {
		Goods goods = new Goods();
		
		if(pm.containsKey("goods_id") && StringUtils.isNoneBlank(pm.getString("goods_id"))) {
			goods.setGoodsId(Integer.valueOf(pm.getString("goods_id")));
		}
		if(pm.containsKey("category_id")) {
			goods.setCategoryId(Integer.valueOf(pm.getString("category_id")));
		}
		if(pm.containsKey("goods_name")) {
			goods.setGoodsName(pm.getString("goods_name"));
		}
		if(pm.containsKey("nickname")) {
			goods.setNickname(pm.getString("nickname"));
		}
		if(pm.containsKey("thumb")) {
			goods.setThumb(pm.getString("thumb"));
		}
		if(pm.containsKey("del_state")) {
			goods.setDelState(Byte.valueOf(pm.getString("del_state")));
		}
		if(pm.containsKey("simple_describe")) {
			goods.setSimpleDescribe(pm.getString("simple_describe"));
		}
		if(pm.containsKey("detail_describe")) {
			goods.setDetailDescribe(pm.getString("detail_describe"));
		}
		if(pm.containsKey("is_marketable")) {
			goods.setIsMarketable(Byte.valueOf(pm.getString("is_marketable")));
		}
		if(pm.containsKey("recommend")) {
			goods.setRecommend(Byte.valueOf(pm.getString("recommend")));
		}
		if(pm.containsKey("admin_id")) {
			goods.setAdminId(Integer.valueOf(pm.getString("admin_id")));
		}
		
		return goods;
		
	}

}
