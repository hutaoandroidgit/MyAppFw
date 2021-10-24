package com.hutao.myappfw.eventbus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.hutao.myappfw.constant.EventName
import com.hutao.myappfw.eventbus.core.EventLiveData

/**
* @ProjectName: MyAppFw
* @Package: com.hutao.myappfw.eventBus
* @ClassName: FwEventBus
* @Description: 事件总线静态单例类
                享元模式 结构型
 * @Author: hutao
* @CreateDate: 2021/10/24 12:03
* @UpdateUser: 更新者
* @UpdateDate: 2021/10/24 12:03
* @UpdateRemark: 更新说明
* @Version: 1.0
*/
object FwEventBus {
    /**
     * 定义map包含事件名称 以及对应的LiveDate
     */
    private val channels = HashMap<String,EventLiveData<*>>()

    private fun <T> with(@EventName eventName: String): EventLiveData<T> {
        /**
         * 享元模式  channels中存在就直接返回 不然就是创建新的LiveDate设置进去
         */
        synchronized(channels) {
            if (!channels.containsKey(eventName)) {
                channels[eventName] = EventLiveData<T>()
            }
            return (channels[eventName] as EventLiveData<T>)
        }
    }
    //下面都是在提供静态外层疯转（外观模式）
    fun <T> post(@EventName eventName: String, message: T) {
        val eventLiveData = with<T>(eventName)
        eventLiveData.postValue(message!!)
    }

    fun <T> observe(owner: LifecycleOwner, @EventName eventName: String, sticky: Boolean = false, observer: Observer<T>) {
        with<T>(eventName).observe(owner, sticky, observer)
    }

    fun <T> observeForever(@EventName eventName: String, sticky: Boolean = false, observer: Observer<T>) {
        with<T>(eventName).observeForever(sticky, observer)
    }
}