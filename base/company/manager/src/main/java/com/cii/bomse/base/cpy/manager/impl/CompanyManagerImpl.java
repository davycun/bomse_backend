package com.cii.bomse.base.cpy.manager.impl;

import com.cii.bomse.base.cpy.dao.ICompanyDao;
import com.cii.bomse.base.cpy.entity.CompanyEntity;
import com.cii.bomse.base.cpy.manager.ICompanyManager;
import com.cii.bomse.ums.user.manager.IUserManager;
import com.cii.bomse.ums.user.dictionary.UserType;
import com.cii.bomse.ums.user.entity.UserEntity;
import com.ciiframework.common.business.AbstractManager;
import com.ciiframework.common.context.CurrentContext;
import com.ciiframework.common.dictionary.SexType;
import com.ciiframework.common.utils.CodeGenUtils;
import com.ciiframework.common.utils.PinyinUtils;
import com.ciiframework.data.mybatis.IMyBatisBaseDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CompanyManagerImpl extends AbstractManager<CompanyEntity> implements ICompanyManager {

    @Autowired
    private ICompanyDao companyDao;

    @Autowired
    private IUserManager userManager;

    @Override
    protected IMyBatisBaseDao<CompanyEntity, Long> getMyBatisDao() {
        return this.companyDao;
    }

    @Override
    @Transactional
    public int create(CompanyEntity cpy) {

        cpy.setCreateId(CurrentContext.getUserId());
        cpy.setCreateName(CurrentContext.getUserInfo().getUserName());
        cpy.setCreateTime(new Date());
        cpy.setLastUpdateTime(new Date());
        cpy.setIsDeleted(Boolean.FALSE);

        cpy.setId(idGenerate.generate());
        cpy.setCpyId(cpy.getId());

        if (StringUtils.isEmpty(cpy.getAliasCode())) {
            cpy.setAliasCode(PinyinUtils.getPinyinFull(cpy.getCpyName()));
        }

        int i = companyDao.insert(cpy);

        createAdmin(cpy);
        return i;
    }
    /**
     * @description 创建管理员账号
     * @author david·cun
     * @param
     * @return
     * @date 2019-04-17 17:12
     * @since 1.0
     */
    private void createAdmin(CompanyEntity cpy){

        UserEntity user = new UserEntity();

        user.setSecure(cpy.getAdminPhone().substring(5));
        user.setUserName("管理员");
        user.setEmail(cpy.getAdminEmail());
        user.setUserPhone(cpy.getAdminPhone()+"admin");
        user.setUserType(UserType.Employee);
        user.setSex(SexType.Sir);
        user.setCpyId(cpy.getId());
        user.setCpyName(cpy.getCpyName());

        userManager.create(user);
    }

    /**
     * @description
     * 查询公司管理的时候，不需要限制限制平台
     * @author david·cun
     * @param
     * @return
     * @date 2019-08-24 09:35
     * @since 1.0
     */
    @Override
    protected boolean isNeedLimitPlatform() {
        return false;
    }

}
