package com.cii.bomse.base.area.dto;

import com.cii.bomse.base.area.entity.AreaEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class AreaDto extends AreaEntity {

    /*可以指定只是查询指定的类型*/
    @ApiModelProperty(value = "支持查询区域类型集合，包括Province、City、Region、Street")
    private List<String> areaTypes;

    private List<String> notAreaTypes;

    public List<String> getNotAreaTypes() {
        return notAreaTypes;
    }

    public void setNotAreaTypes(List<String> notAreaTypes) {
        this.notAreaTypes = notAreaTypes;
    }

    public List<String> getAreaTypes() {
        return areaTypes;
    }

    public void setAreaTypes(List<String> areaTypes) {
        this.areaTypes = areaTypes;
    }
}
