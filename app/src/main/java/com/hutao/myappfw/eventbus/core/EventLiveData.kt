package com.hutao.myappfw.eventbus.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.eventBus.core
 * @ClassName: EventLiveData
 * @Description: 事件LiveData
 *              观察者模式 属于LiveData自己带的
 * @Author: hutaov
 * @CreateDate: 2021/10/24 12:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 12:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class EventLiveData<T> : MutableLiveData<T>(){
    fun observe(owner : LifecycleOwner , sticky : Boolean , observer: Observer<in T>){
        /**
         * 调用到LiveData设置observer的observe方法
         */
        observe(owner, wrapObserver(sticky,observer))
    }

    /**
     * observeForever 事件不会被自动删除 只能调用removeObserver停止观察
     * @param sticky Boolean
     * @param observer Observer<in T>
     */
    fun observeForever(sticky: Boolean, observer: Observer<in T>) {
        observeForever(wrapObserver(sticky, observer))
    }
    /**
     * 返回装饰之后的观察者
     * @param sticky Boolean
     * @param observer Observer<in T>
     * @return Observer<T>
     */
    private fun wrapObserver(sticky: Boolean, observer: Observer<in T>): Observer<T> {
        return EventObserverWrapper<T>(this,sticky,observer)
    }
}