package com.cii.bomse.bi.entity;

/**
 * @description
 * @auth david·cun
 * @date 2019-09-18 15:54
 * @since 1.0
 */
public class CustomerStatisticReportEntity extends BaseReportEntity {

    //跟进中的客户
    private Float followupCustomerCount = 0f;
    //隐藏的客户数据
    private Float hideCustomerCount = 0f;
    //待判断客户量
    private Float customerHasRentCount = 0f;
    //待判断客户量
    private Float waitJudgeCustomerCount = 0f;
    //判断可承接，但是待勘查的客户
    private Float waitSurveyCustomerCount = 0f;
    //可承接，已勘查的客户
    private Float hasSurveyCustomerCount = 0f;
    //优质客户量
    private Float customerIntentionYouCount = 0f;
    //良客户量
    private Float customerIntentionLiangCount = 0f;
    //中客户量
    private Float customerIntentionZhongCount = 0f;
    //差客户量
    private Float customerIntentionChaCount = 0f;
    //未知意向度的客户
    private Float customerIntentionUnknownCount = 0f;
    //3天未跟进客户量
    private Float customerNotFollowup3DayCount = 0f;
    //7天未跟进的客户
    private Float customerNotFollowup7DayCount = 0f;

    public Float getCustomerHasRentCount() {
        return customerHasRentCount;
    }

    public void setCustomerHasRentCount(Float customerHasRentCount) {
        this.customerHasRentCount = customerHasRentCount;
    }

    public Float getHasSurveyCustomerCount() {
        return hasSurveyCustomerCount;
    }

    public void setHasSurveyCustomerCount(Float hasSurveyCustomerCount) {
        this.hasSurveyCustomerCount = hasSurveyCustomerCount;
    }

    public Float getCustomerIntentionUnknownCount() {
        return customerIntentionUnknownCount;
    }

    public void setCustomerIntentionUnknownCount(Float customerIntentionUnknownCount) {
        this.customerIntentionUnknownCount = customerIntentionUnknownCount;
    }

    public Float getFollowupCustomerCount() {
        return followupCustomerCount;
    }

    public void setFollowupCustomerCount(Float followupCustomerCount) {
        this.followupCustomerCount = followupCustomerCount;
    }

    public Float getHideCustomerCount() {
        return hideCustomerCount;
    }

    public void setHideCustomerCount(Float hideCustomerCount) {
        this.hideCustomerCount = hideCustomerCount;
    }

    public Float getWaitJudgeCustomerCount() {
        return waitJudgeCustomerCount;
    }

    public void setWaitJudgeCustomerCount(Float waitJudgeCustomerCount) {
        this.waitJudgeCustomerCount = waitJudgeCustomerCount;
    }

    public Float getWaitSurveyCustomerCount() {
        return waitSurveyCustomerCount;
    }

    public void setWaitSurveyCustomerCount(Float waitSurveyCustomerCount) {
        this.waitSurveyCustomerCount = waitSurveyCustomerCount;
    }

    public Float getCustomerIntentionYouCount() {
        return customerIntentionYouCount;
    }

    public void setCustomerIntentionYouCount(Float customerIntentionYouCount) {
        this.customerIntentionYouCount = customerIntentionYouCount;
    }

    public Float getCustomerIntentionLiangCount() {
        return customerIntentionLiangCount;
    }

    public void setCustomerIntentionLiangCount(Float customerIntentionLiangCount) {
        this.customerIntentionLiangCount = customerIntentionLiangCount;
    }

    public Float getCustomerIntentionZhongCount() {
        return customerIntentionZhongCount;
    }

    public void setCustomerIntentionZhongCount(Float customerIntentionZhongCount) {
        this.customerIntentionZhongCount = customerIntentionZhongCount;
    }

    public Float getCustomerIntentionChaCount() {
        return customerIntentionChaCount;
    }

    public void setCustomerIntentionChaCount(Float customerIntentionChaCount) {
        this.customerIntentionChaCount = customerIntentionChaCount;
    }

    public Float getCustomerNotFollowup3DayCount() {
        return customerNotFollowup3DayCount;
    }

    public void setCustomerNotFollowup3DayCount(Float customerNotFollowup3DayCount) {
        this.customerNotFollowup3DayCount = customerNotFollowup3DayCount;
    }

    public Float getCustomerNotFollowup7DayCount() {
        return customerNotFollowup7DayCount;
    }

    public void setCustomerNotFollowup7DayCount(Float customerNotFollowup7DayCount) {
        this.customerNotFollowup7DayCount = customerNotFollowup7DayCount;
    }
}
