package com.cii.bomse.base.area.manager.impl;

import com.cii.bomse.base.area.entity.AreaEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.utils.ObjectUtils;

import java.util.*;

/**
 * @description
 * @auth david·cun
 * @date 2019-05-29 19:51
 * @since 1.0
 */
public abstract class AbstractAreaManager<T extends AreaEntity> extends AbstractManager<T> {

    /**
     * @description 组织成树形结构，并且排序，排序根据菜单排序字段，从小到大排序
     * @author david·cun
     * @param
     * @return
     * @ate 2019-04-10 11:36
     * @since 1.0
     */
    public List<T> treeAndSort(List<T> areas) {
        List<T> result = new ArrayList<>();

        Map<Long, T> tmp = new HashMap<>();
        List<Long> removeCode = new ArrayList<>();

        for (T area : areas) {
            tmp.put(area.getId(), area);
        }

        //把每个节点关联上
        for (T area : areas) {
            T parentArea = tmp.get(area.getParentId());
            if (ObjectUtils.isNotEmpty(parentArea)) {
                List<AreaEntity> children = parentArea.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parentArea.setChildren(children);
                }
                children.add(area);
                removeCode.add(area.getId());
            }
        }

        //把已经关联上的节点从顶层移除
        for (Long code : removeCode) {
            tmp.remove(code);
        }

        for (Map.Entry<Long, T> entry : tmp.entrySet()) {
            result.add(entry.getValue());
        }

        sort(result);

        return result;
    }

    public void sort(List<T> areas) {
        for (T area : areas) {
            if (null != area.getChildren() && area.getChildren().size() > 1) {
                sort((List<T>) area.getChildren());
            }
        }
        Collections.sort(areas, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getSort() - o2.getSort();
            }
        });
    }

}
