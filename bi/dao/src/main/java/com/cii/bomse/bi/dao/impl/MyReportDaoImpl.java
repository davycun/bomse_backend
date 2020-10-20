package com.cii.bomse.bi.dao.impl;

import com.cii.bomse.bi.dao.IMyReportDao;
import com.cii.bomse.bi.entity.MyReportEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class MyReportDaoImpl extends AbstractMyBatisDao<MyReportEntity,Long> implements IMyReportDao {
}
