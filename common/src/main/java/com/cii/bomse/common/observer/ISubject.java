package com.cii.bomse.common.observer;

/**
 * @description
 * @auth david·cun
 * @date 2019-11-13 14:25
 * @since 1.0
 */
public interface ISubject<T extends IObserver> {

    /**
     * @description
     * 添加观察者
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-13 14:27
     * @since 1.0
     */
    void attach(T observer);

    /**
     * @description
     * 通知所有观察者
     * @author david·cun
     * @param
     * @return
     * @date 2019-11-13 14:28
     * @since 1.0
     */
    void notifyAllObserver();
}
