package cn.ccrm.admin.entity;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private Integer categoryId;

    private String goodsName;

    private String nickname;

    private String thumb;

    private Byte delState;

    private String simpleDescribe;

    private Byte isMarketable;

    private Byte recommend;

    private Date createTime;

    private Date updateTime;

    private Integer adminId;

    private String detailDescribe;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public Byte getDelState() {
        return delState;
    }

    public void setDelState(Byte delState) {
        this.delState = delState;
    }

    public String getSimpleDescribe() {
        return simpleDescribe;
    }

    public void setSimpleDescribe(String simpleDescribe) {
        this.simpleDescribe = simpleDescribe == null ? null : simpleDescribe.trim();
    }

    public Byte getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Byte isMarketable) {
        this.isMarketable = isMarketable;
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

    public String getDetailDescribe() {
        return detailDescribe;
    }

    public void setDetailDescribe(String detailDescribe) {
        this.detailDescribe = detailDescribe == null ? null : detailDescribe.trim();
    }
}