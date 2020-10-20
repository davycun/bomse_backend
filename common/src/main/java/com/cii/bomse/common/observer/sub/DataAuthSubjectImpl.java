package com.cii.bomse.common.observer.sub;

import com.cii.bomse.common.observer.IDataAuthObserver;
import com.cii.bomse.common.observer.IDataAuthSubject;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-13 14:42
 * @since 1.0
 */
@Component
public class DataAuthSubjectImpl extends AbstractSubject<IDataAuthObserver> implements IDataAuthSubject {

}
