package cn.ccrm.admin.service;

import cn.ccrm.admin.entity.GoodsPrice;
import cn.ccrm.admin.util.ParameterMap;

public interface IGoodsPriceService {
	
	public GoodsPrice getGoodsPriceById(GoodsPrice gp);
	
	public void insert(GoodsPrice gp);
	
	public void update(GoodsPrice gp);
	
}
