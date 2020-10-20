package com.cii.bomse.hrm.dept.entity;

import com.cii.bomse.hrm.dept.dictionary.DeptShareState;
import com.ciiframework.common.generator.NotGenerate;
import com.ciiframework.dictionary.DictionaryStorage;
import com.ciiframework.entity.BaseEntity;

/**
 * @description
 * 目前支持从后端直接配置，如果开发给经历从移动端进行申请配置，需要用到DeptShareState
 * @auth david·cun
 * @date 2020-05-31 15:29
 * @since 1.0
 */
public class DeptShareEntity extends BaseEntity {

    private Long deptFromId;
    private String deptFromName;

    private Long deptToId;
    private String deptToName;

    /**
     * 共享状态
     * @see com.cii.bomse.hrm.dept.dictionary.DeptShareState
     */
    private String shareState;
    @NotGenerate
    private String shareStateName;

    public String getShareStateName() {
        return DictionaryStorage.get(DeptShareState.class.getName(),shareState).getName();
    }

    public void setShareStateName(String shareStateName) {
        this.shareStateName = shareStateName;
    }

    public String getShareState() {
        return shareState;
    }

    public void setShareState(String shareState) {
        this.shareState = shareState;
    }

    public Long getDeptFromId() {
        return deptFromId;
    }

    public void setDeptFromId(Long deptFromId) {
        this.deptFromId = deptFromId;
    }

    public String getDeptFromName() {
        return deptFromName;
    }

    public void setDeptFromName(String deptFromName) {
        this.deptFromName = deptFromName;
    }

    public Long getDeptToId() {
        return deptToId;
    }

    public void setDeptToId(Long deptToId) {
        this.deptToId = deptToId;
    }

    public String getDeptToName() {
        return deptToName;
    }

    public void setDeptToName(String deptToName) {
        this.deptToName = deptToName;
    }
}
