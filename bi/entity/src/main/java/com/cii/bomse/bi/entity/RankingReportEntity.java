package com.cii.bomse.bi.entity;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-21 14:25
 * @since 1.0
 */
public class RankingReportEntity extends BaseReportEntity {

    /*人员头像*/
    private String avatar;

    /*类型，比如三条折线在一起的时候，指定不同的类型*/
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
