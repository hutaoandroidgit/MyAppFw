package com.hutao.myappfw.bean

import com.hutao.myappfw.base.BaseFragment
import com.hutao.myappfw.constant.TabId
import kotlin.reflect.KClass

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.bean
 * @ClassName: Tab
 * @Description: 底栏对象数据结构
 * @Author: hutao
 * @CreateDate: 2021/10/23 16:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 16:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
data class Tab(
    @TabId
    val id: String,
    val title: String,
    val icon: Int,
    val fragmentClz: KClass<out BaseFragment>
)