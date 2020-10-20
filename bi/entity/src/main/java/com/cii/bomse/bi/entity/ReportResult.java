package com.cii.bomse.bi.entity;

import com.ciiframework.utils.ObjectUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.*;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-07 14:34
 * @since 1.0
 */
public class ReportResult<T extends BaseReportEntity> implements Serializable {

    /*当前查询节点的ID，可能是人员ID，可能是部门ID*/
    private Long id;
    /*当前报表是部门报表还是个人报表*/
    private boolean isDept;
    /*最初生成的结果集*/
    private Map<String, T> result;
    /*如果当前节点是部门，那么此处存储的是当前节点下的所有子部门ID*/
    private List<Long> deptIdList;
    /*如果当前节点有子部门，那么此处存储的每个子部门下，各个子部门对应的子部门部门拼接字符串用来处理运算*/
    private Map<Long, String> deptIdString;
    /*查询开始时间*/
    private Date startTime;
    /*查询结束时间*/
    private Date endTime;

    private String startTimeString;
    private String endTimeString;

    public ReportResult(Long id, boolean isDept, Date startTime, Date endTime) {

        this.id = id;
        this.isDept = isDept;

        if (ObjectUtils.isEmpty(startTime)) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            startTime = calendar.getTime();
        }

        if (ObjectUtils.isEmpty(endTime)) {
            endTime = Calendar.getInstance().getTime();
        }

        this.startTimeString = DateFormatUtils.format(startTime, "yyyy-MM-dd");
        this.endTimeString = DateFormatUtils.format(DateUtils.addDays(
                endTime, 1), "yyyy-MM-dd");

        try {
            this.startTime = DateUtils.parseDate(startTimeString, "yyyy-MM-dd");
            this.endTime = DateUtils.parseDate(endTimeString, "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private Map<String, PropertyDescriptor> pdCache = new HashMap<>();

    public Method getReadMethod(Class cls, String field) {
        return getPd(cls, field).getReadMethod();
    }

    public Method getWriteMethod(Class cls, String field) {
        return getPd(cls, field).getWriteMethod();
    }

    private PropertyDescriptor getPd(Class cls, String field) {
        PropertyDescriptor pd = pdCache.get(cls.getName() + "." + field);
        if (ObjectUtils.isEmpty(pd)) {
            try {
                pd = new PropertyDescriptor(field, cls);
                pdCache.put(cls.getName() + "." + field, pd);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        }
        return pd;
    }

    public void addResult(String field, T target, T source) {
        try {
            Method read = getReadMethod(target.getClass(), field);
            Method write = getWriteMethod(target.getClass(), field);
            write.invoke(target, (Float) read.invoke(target) + source.getCount());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void addDeptResult(String field, List<T> list) {
        if (ObjectUtils.isNotEmpty(list)) {
            for (T source : list) {
                for (Map.Entry<Long, String> ds : getDeptIdString().entrySet()) {
                    if (ds.getValue().contains(source.getId().toString())) {
                        T target = getResult().get(ds.getKey().toString());
                        if (ObjectUtils.isNotEmpty(target)) {
                            addResult(field, target, source);
                        }
                    }
                }
            }
        }
    }

    public void addResult(String field, List<T> list) {
        if (ObjectUtils.isNotEmpty(list)) {
            for (T now : list) {
                T target = getResult().get(now.getId().toString());
                if (ObjectUtils.isNotEmpty(target)) {
                    addResult(field, target, now);
                }
            }
        }
    }

    public void addResult(String field, List<T> list, String idField) {
        if (ObjectUtils.isNotEmpty(list)) {
            for (T source : list) {
                try {
                    String id = getReadMethod(source.getClass(), idField).invoke(source).toString();
                    T target = getResult().get(id);
                    if (ObjectUtils.isNotEmpty(target)) {
                        addResult(field, target, source);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    public List<T> getResultList() {
        List<T> list = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(result)) {
            Set<Map.Entry<String, T>> set = result.entrySet();
            for (Map.Entry<String, T> entry : set) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    public String getStartTimeString() {
        if (ObjectUtils.isEmpty(startTime)) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            startTime = calendar.getTime();
        }
        return DateFormatUtils.format(startTime, "yyyy-MM-dd");
    }

    public String getEndTimeString() {
        if (ObjectUtils.isEmpty(endTime)) {
            endTime = Calendar.getInstance().getTime();
        }
        return DateFormatUtils.format(DateUtils.addDays(endTime, 1), "yyyy-MM-dd");
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsDept() {
        return isDept;
    }

    public void setIsDept(boolean isDept) {
        this.isDept = isDept;
    }

    public Map<String, T> getResult() {
        if (ObjectUtils.isEmpty(result)) {
            this.result = new HashMap<>();
        }
        return result;
    }

    public void setResult(Map<String, T> result) {
        this.result = result;
    }

    public List<Long> getDeptIdList() {
        if (ObjectUtils.isEmpty(deptIdList)) {
            this.deptIdList = new ArrayList<>();
        }
        return deptIdList;
    }

    public void setDeptIdList(List<Long> deptIdList) {
        this.deptIdList = deptIdList;
    }

    public Map<Long, String> getDeptIdString() {
        if (ObjectUtils.isEmpty(deptIdString)) {
            this.deptIdString = new HashMap<>();
        }
        return deptIdString;
    }

    public void setDeptIdString(Map<Long, String> deptIdString) {
        this.deptIdString = deptIdString;
    }
}
