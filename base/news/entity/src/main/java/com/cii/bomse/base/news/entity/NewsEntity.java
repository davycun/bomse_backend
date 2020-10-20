package com.cii.bomse.base.news.entity;

import com.cii.bomse.base.news.dictionary.NewsType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

import javax.validation.constraints.NotNull;

public class NewsEntity extends BaseEntity {

    /**
     * 新闻标题
     */
    @NotNull(message = "资讯标题不能为空")
    private String newsTitle;

    /**
     * 资讯类型
     * @see com.cii.bomse.base.news.dictionary.NewsType
     */
    @NotNull(message = "资讯类型不能为空")
    private String newsType;
    private String newsTypeName;

    /**
     * 列表图片
     */
    @NotNull(message = "资讯缩略图不能为空")
    private String avatar;
    /**
     * 摘要，简介说明
     */
    @NotNull(message = "资讯摘要不能为空")
    private String brief;

    /**
     * 推广关键字
     */
    @NotNull(message = "SEO推广关键字不能为空")
    private String keywords;

    /**
     * 推广描述
     */
    @NotNull(message = "SEO推广描述不能为空")
    private String description;

    /**
     * 文章内容
     */
    @NotNull(message = "资讯内容不能为空")
    private String content;

    /**
     * 浏览量
     */
    private Long readCount;

    /**
     * 点赞量
     */
    private Long praiseCount;

    /**
     * 分享量
     */
    private Long shareCount;

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getShareCount() {
        return shareCount;
    }

    public void setShareCount(Long shareCount) {
        this.shareCount = shareCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewsTypeName() {
        return DictionaryStorage.get(NewsType.class.getName(),this.getNewsType()).getName();
    }

    public void setNewsTypeName(String newsTypeName) {
        this.newsTypeName = newsTypeName;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }
}
