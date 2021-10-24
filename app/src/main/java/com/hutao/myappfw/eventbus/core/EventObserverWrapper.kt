package com.hutao.myappfw.eventbus.core

import androidx.lifecycle.Observer
import com.hutao.myappfw.util.reflect.ReflectHelper

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.eventBus.core
 * @ClassName: EventObserverWrapper
 * @Description: 事件观察者装饰类
 * 装饰模式 - 结构型 包装Observer
 * @Author: hutao
 * @CreateDate: 2021/10/24 12:25
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 12:25
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class EventObserverWrapper<T>(
    liveData: EventLiveData<T>,
    sticky : Boolean,
    private val observerDelegate: Observer<in T>
):Observer<T>{

    private var preventNextEvent = false

    companion object {
        private const val START_VERSION = -1
    }

    init {
        if (!sticky) {
            /**
             * 反射出liveData 的mVersion
             * 这里判断出preventNextEvent不确认什么原因
             */
            val version = ReflectHelper.of(liveData).getField("mVersion") as? Int ?: START_VERSION
            preventNextEvent = version > START_VERSION
        }
    }

    override fun onChanged(t: T) {
        if (preventNextEvent) {
            preventNextEvent = false
            return
        }
        observerDelegate.onChanged(t)
    }

}