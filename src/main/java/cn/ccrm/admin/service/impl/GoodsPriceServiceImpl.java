package cn.ccrm.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ccrm.admin.dao.GoodsPriceMapper;
import cn.ccrm.admin.entity.GoodsPrice;
import cn.ccrm.admin.service.IGoodsPriceService;

@Service
public class GoodsPriceServiceImpl implements IGoodsPriceService {
	
	@Autowired
	private GoodsPriceMapper goodsPriceDao;
	
	private Logger logger = LoggerFactory.getLogger(GoodsPriceServiceImpl.class);

	@Override
	public GoodsPrice getGoodsPriceById(GoodsPrice gp) {
		
		try {
			GoodsPrice goodsPrice = goodsPriceDao.selectByPrimaryKey(gp.getPriceId());
			return goodsPrice;
		} catch (Exception e) {
			logger.error("查询产品价格出现异常：{}", e.getMessage());
		}
		
		return null;
	}

	@Override
	public void insert(GoodsPrice gp) {
		try {
			int insertResult = goodsPriceDao.insert(gp);
		} catch (Exception e) {
			logger.error("产品价格录入异常：{}", e.getMessage());
		}
	}

	@Override
	public void update(GoodsPrice gp) {
		try {
			goodsPriceDao.updateByPrimaryKeySelective(gp);
		} catch (Exception e) {
			logger.error("产品价格更新异常：{}", e.getMessage());
			e.printStackTrace();
		}
	}

}
