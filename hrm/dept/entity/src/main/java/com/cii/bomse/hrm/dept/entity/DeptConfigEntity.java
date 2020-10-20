package com.cii.bomse.hrm.dept.entity;

import com.cii.bomse.base.area.dictionary.AreaType;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;
import com.ciiframework.utils.ObjectUtils;

/**
 * @description
 * @auth david·cun
 * @date 2020-03-30 11:43
 * @since 1.0
 */
public class DeptConfigEntity extends BaseEntity {

    private Long deptId;
    private String deptName;

    /**
     * 设置部门可以访问的区域级别
     *
     * @see com.cii.bomse.base.area.dictionary.AreaType
     */
    private String areaType;
    @NotGenerate
    private String areaTypeName;

    /**是否共享部门内部个人客户*/
    private Boolean sharePersonalCustomer;

    /**默认配置项*/
    private DeptConfigEntity defaultConfig;

    public Boolean getSharePersonalCustomer() {
        return sharePersonalCustomer;
    }

    public void setSharePersonalCustomer(Boolean sharePersonalCustomer) {
        this.sharePersonalCustomer = sharePersonalCustomer;
    }

    public String getAreaTypeName() {
        return DictionaryStorage.get(AreaType.class.getName(), areaType).getName();
    }

    public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAreaType() {
        return ObjectUtils.isEmpty(areaType) ? defaultConfig.getAreaType() : areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public DeptConfigEntity getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(DeptConfigEntity defaultConfig) {
        this.defaultConfig = defaultConfig;
    }
}
