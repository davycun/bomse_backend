package com.cii.bomse.hrm.dept.manager.impl;

import com.cii.bomse.common.observer.IDataAuthObserver;
import com.cii.bomse.common.observer.IDataAuthSubject;
import com.cii.bomse.hrm.dept.dao.IDeptDao;
import com.cii.bomse.hrm.dept.entity.DeptEntity;
import com.cii.bomse.hrm.dept.manager.IDeptManager;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/10 14:10
 */
@Service
public class DeptManagerImpl extends AbstractManager<DeptEntity> implements IDeptManager, IDataAuthObserver {

    @Autowired
    private IDeptDao deptDao;
    @Autowired
    private IDataAuthSubject dataAuthSubject;

    private Map<Long,List<Long>> userAuthDeptIdList;
    private Map<Long,List<DeptEntity>> userAuthDeptList;


    public DeptManagerImpl(){
        userAuthDeptIdList = new HashMap<>();
        userAuthDeptList = new HashMap<>();
    }

    @Override
    protected IMyBatisBaseDao<DeptEntity, Long> getMyBatisDao() {
        return deptDao;
    }

    @Override
    protected void beforeBatchCreate(List<DeptEntity> list) {
        for (DeptEntity dept : list) {
            if (ObjectUtils.isEmpty(dept.getParentId())) {
                dept.setParentId(0L);
            }
        }
    }

    @Override
    protected void afterBatchUpdate(List<DeptEntity> list) {
        dataAuthSubject.notifyAllObserver();
    }

    @Override
    protected void afterBatchCreate(List<DeptEntity> list) {
        dataAuthSubject.notifyAllObserver();
    }

    @Override
    public List<DeptEntity> findByMapToTree(Map<String, Object> param) {
        addCpyId(param);
        return tree(deptDao.selectByMap(param));
    }

    @Override
    public List<DeptEntity> findByRoleToList(Long dataRoleId) {
        Map<String, Object> param = new HashMap<>();
        param.put("roleId", dataRoleId);
        addCpyId(param);
        List<DeptEntity> dept = deptDao.selectByStatement("selectDeptByRole", param);
        return dept;
    }

    @Override
    public List<DeptEntity> findByUserToList(Long userId) {
        Map<String, Object> param = new HashMap<>();
        param.put("userId", userId);
        addCpyId(param);
        List<DeptEntity> dept = deptDao.selectByStatement("selectDeptByUser", param);
        return dept;
    }

    /**
     * @param
     * @return
     * @description 查找某个部门及所有子部门以树形结构返回
     * @author david·cun
     * @ate 2019-04-10 14:59
     * @since 1.0
     */
    @Override
    public DeptEntity findByParentToTree(Long parentId) {

        Map<String, Object> param = new HashMap<>();
        param.put("isDeleted", false);
        addCpyId(param);

        List<DeptEntity> dept = deptDao.selectByMap(param);
        DeptEntity dp = null;
        for (DeptEntity tmp : dept) {
            if (tmp.getId().equals(parentId)) {
                dp = tmp;
                break;
            }
        }

        tree(dept);

        return dp;
    }

    @Override
    public List<DeptEntity> findByParentToList(Long parentId) {
        List<DeptEntity> list = new ArrayList<>();
        list.add(findByParentToTree(parentId));

        return treeToList(list);
    }

    @Override
    public List<DeptEntity> findUserAuthDeptToList(Long userId) {

        List<DeptEntity> deptList = userAuthDeptList.get(userId);
        if (ObjectUtils.isEmpty(deptList)){
            List<DeptEntity> dept = findByUserToList(userId);
            dept.addAll(findLeaderDeptToList(userId));
            deptList =  removeDuplicate(dept);
            userAuthDeptList.put(userId,deptList);
        }
        return deptList;
    }
    @Override
    public List<DeptEntity> findUserAuthDeptToTree(Long userId) {
        return tree(findUserAuthDeptToList(userId));
    }

    @Override
    public List<Long> findUserAuthDeptId(Long userId) {

        List<Long> deptIdList = userAuthDeptIdList.get(userId);

        if (deptIdList == null){
            List<DeptEntity> deptS = findUserAuthDeptToList(userId);
            deptIdList = new ArrayList<>();
            for (DeptEntity d : deptS){
                deptIdList.add(d.getId());
            }
            userAuthDeptIdList.put(userId,deptIdList);
        }

        return deptIdList;
    }
    @Override
    public List<DeptEntity> findLeaderDeptToList(Long userId) {
        Map<String, Object> param = new HashMap<>();
        param.put("isDeleted", Boolean.FALSE);
        param.put("leaderId", userId);


        //找到我是领导人的所有部门，以树形结构返回
        List<DeptEntity> leaderDept = findByMap(param);
        List<DeptEntity> leaderDeptList = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(leaderDept)) {
            for (DeptEntity dp : leaderDept) {
                leaderDeptList.addAll(findByParentToList(dp.getId()));
            }
        }
        //需要去重的原因是有可能上级部门的领导也可能兼任子级部门领导
        return removeDuplicate(leaderDeptList);
    }
    @Override
    public List<DeptEntity> findLeaderDeptToTree(Long userId) {
        return tree(findLeaderDeptToList(userId));
    }
    @Override
    public List<Long> findLeaderDeptId(Long userId) {
        List<DeptEntity> deptS = findLeaderDeptToList(userId);
        List<Long> list = new ArrayList<>();
        for (DeptEntity d : deptS){
            list.add(d.getId());
        }
        return list;
    }

    public List<DeptEntity> treeToList(List<DeptEntity> list) {

        List<DeptEntity> result = new ArrayList<>();
        if (ObjectUtils.isEmpty(list)) {
            return result;
        }

        for (DeptEntity d : list) {
            result.add(d);
            result.addAll(treeToList(d.getChildren()));
        }
        return result;
    }

    /**
     * @param
     * @return
     * @description 把部门列表以树状进行组织并排序
     * @author david·cun
     * @ate 2019-04-10 14:58
     * @since 1.0
     */
    @Override
    public List<DeptEntity> tree(List<DeptEntity> list) {

        List<DeptEntity> result = new ArrayList<>();

        Map<Long, DeptEntity> tmp = new HashMap<>();
        List<Long> removeCode = new ArrayList<>();

        for (DeptEntity dept : list) {
            tmp.put(dept.getId(), dept);
            //开始之前先把之前的关系剔除
            dept.setChildren(null);
        }

        //把每个节点关联上
        for (DeptEntity dept : list) {
            DeptEntity parentMenu = tmp.get(dept.getParentId());
            if (ObjectUtils.isNotEmpty(parentMenu)) {
                List<DeptEntity> children = parentMenu.getChildren();
                if (children == null) {
                    children = new ArrayList<>();
                    parentMenu.setChildren(children);
                }
                children.add(dept);
                removeCode.add(dept.getId());
            }
        }

        //把已经关联上的节点从顶层移除
        for (Long code : removeCode) {
            tmp.remove(code);
        }

        for (Map.Entry<Long, DeptEntity> entry : tmp.entrySet()) {
            result.add(entry.getValue());
        }
        return sort(result);
    }

    /**
     * @description
     * 去除重复的
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-24 11:25
     * @since 1.0
     */
    public List<DeptEntity> removeDuplicate(List<DeptEntity> list){

        Map<Long,DeptEntity> tmp = new HashMap<>();
        List<DeptEntity> result = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(list)){
            for (DeptEntity dept : list){
                dept.setChildren(null);
                tmp.put(dept.getId(),dept);
            }
        }

        if (ObjectUtils.isNotEmpty(tmp)){
            for (Map.Entry<Long,DeptEntity> entry : tmp.entrySet()){
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public List<DeptEntity> sort(List<DeptEntity> deptS) {

        if (ObjectUtils.isNotEmpty(deptS)){
            for (DeptEntity dept : deptS) {
                if (ObjectUtils.isNotEmpty(dept.getChildren())) {
                    sort(dept.getChildren());
                }
            }

            Collections.sort(deptS);
        }

        return deptS;
    }



    @Override
    public void update() {
        //清空缓存
        userAuthDeptIdList.clear();
        userAuthDeptList.clear();
    }
}
