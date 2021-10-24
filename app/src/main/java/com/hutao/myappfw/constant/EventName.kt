package com.hutao.myappfw.constant

import androidx.annotation.StringDef

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.constant
 * @ClassName: EventName
 * @Description: 事件名称定义
 *              后续这里都是可以扩展的 目前只是刷新homelist数据的事件
 * @Author: hutao
 * @CreateDate: 2021/10/24 13:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 13:24
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@StringDef(EventName.REFRESH_HOME_LIST)
@Retention(AnnotationRetention.SOURCE)
annotation class EventName{
    companion object{
        const val REFRESH_HOME_LIST = "refresh_home_list"
    }
}
