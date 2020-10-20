package com.cii.bomse.common.observer.sub;

import com.cii.bomse.common.observer.IMenuAuthObserver;
import com.cii.bomse.common.observer.IMenuAuthSubject;
import org.springframework.stereotype.Component;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-16 11:54
 * @since 1.0
 */
@Component
public class MenuAuthSubjectImpl extends AbstractSubject<IMenuAuthObserver> implements IMenuAuthSubject {
}
