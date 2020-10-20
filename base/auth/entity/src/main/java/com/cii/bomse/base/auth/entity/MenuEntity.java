package com.cii.bomse.base.auth.entity;

import com.cii.bomse.base.auth.dictionary.MenuType;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2018/12/27 16:34
 */
public class MenuEntity extends BaseEntity implements Comparable<MenuEntity> {

    /**
     * 菜单名称
     */
    @NotNull(message = "菜单名称不能为空")
    private String menuName;

    /**
     * 父菜单
     */
    private Long parentId;
    /**
     * 菜单类型
     * @see MenuType
     */
    @NotNull(message = "菜单类型不能为空")
    private String menuType;
    private String menuTypeName;

    /*接口调用地址*/
    private String menuUrl;

    /*表示menuType是否是menu而不是Function，就是菜单非叶子节点非功能节点*/
    private Boolean isMenu;
    /**
     * 菜单层级
     */
    private Integer level;
    /**
     * 菜单排序
     */
    private Integer sort = Integer.valueOf(0);

    private List<MenuEntity> children;

    /**====针对前端元素的====*/
    /**
     * 指定前端元素ID
     */
    @NotNull(message = "itemId代表菜单的key，全局唯一，必填")
    private String itemId;

    /**
     * 指定元素的Class
     */
    private String itemClass;

    /**
     * 指定元素的图标
     */
    private String itemIcon;

    /**
     * 指定元素的包名
     */
    private String itemPack;

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Boolean getIsMenu() {
        return MenuType.Menu.equals(this.getMenuType());
    }

    public void setIsMenu(Boolean isMenu) {
        this.isMenu = isMenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuTypeName() {
        return DictionaryStorage.get(MenuType.class.getName(),this.menuType).getName();
    }

    public void setMenuTypeName(String menuTypeName) {
        this.menuTypeName = menuTypeName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getItemPack() {
        return itemPack;
    }

    public void setItemPack(String itemPack) {
        this.itemPack = itemPack;
    }

    @Override
    public int compareTo(MenuEntity o) {

        if (ObjectUtils.isNotEmpty(o)){
            return this.getSort() - o.getSort();
        }

        return 1;
    }
}
