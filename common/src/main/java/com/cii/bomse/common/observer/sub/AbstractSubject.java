package com.cii.bomse.common.observer.sub;

import com.cii.bomse.common.observer.IObserver;
import com.cii.bomse.common.observer.ISubject;
import com.ciiframework.utils.GenericsUtils;
import com.ciiframework.utils.ObjectUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-13 14:30
 * @since 1.0
 */
public abstract class AbstractSubject<T extends IObserver> implements ISubject<T>, ApplicationContextAware {

    private List<IObserver> observers;
    private ApplicationContext context;


    public AbstractSubject(){
        observers = new ArrayList<>();
    }

    @PostConstruct
    public void init(){

        Map<String, T> map = context.getBeansOfType(GenericsUtils.getSuperClassGenricType(getClass()));

        if (ObjectUtils.isNotEmpty(map)){
            for (Map.Entry<String,T> entry : map.entrySet()){

                this.attach(entry.getValue());
            }
        }
    }

    @Override
    public void attach(T observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyAllObserver() {
        if (ObjectUtils.isNotEmpty(observers)){
            for (IObserver observer : observers){
                observer.update();
            }
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
