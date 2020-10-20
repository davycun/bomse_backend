package com.cii.bomse.base.cpy.dao.impl;

import com.cii.bomse.base.cpy.dao.ICompanyDao;
import com.cii.bomse.base.cpy.entity.CompanyEntity;
import com.ciiframework.data.mybatis.AbstractMyBatisDao;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl extends AbstractMyBatisDao<CompanyEntity,Long> implements ICompanyDao{
}
