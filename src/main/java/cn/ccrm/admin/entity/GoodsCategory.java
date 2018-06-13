package cn.ccrm.admin.entity;

import java.util.Date;
import java.util.List;

public class GoodsCategory {
	private Integer categoryId;

	private Integer parentId;

	private String categoryName;

	private String image;

	private Byte state;

	private String simpleDescribe;

	private Byte recommend;

	private Date createTime;

	private Date updateTime;

	private Integer adminId;

	private List<GoodsCategory> subMenu;

	private boolean hasMenu = false;

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}

	public List<GoodsCategory> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<GoodsCategory> subMenu) {
		this.subMenu = subMenu;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image == null ? null : image.trim();
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public String getSimpleDescribe() {
		return simpleDescribe;
	}

	public void setSimpleDescribe(String simpleDescribe) {
		this.simpleDescribe = simpleDescribe == null ? null : simpleDescribe.trim();
	}

	public Byte getRecommend() {
		return recommend;
	}

	public void setRecommend(Byte recommend) {
		this.recommend = recommend;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
}