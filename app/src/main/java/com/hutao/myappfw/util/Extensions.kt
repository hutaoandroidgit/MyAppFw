package com.hutao.myappfw.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.util
 * @ClassName: Extensions
 * @Description: Kotlin扩展属性和扩展函数
 *               .kt文件 不是类文件 kotlin容许这样无类名称的文件 包含函数
 *               如果需要和java互通调用 可以加上@file:JvmName("Extensions") 注解
 * @Author: hutao
 * @CreateDate: 2021/10/23 15:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 15:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */

fun Boolean.toVisibility() = if (this) View.VISIBLE else View.GONE

fun Context.getActivity() : Activity?{
    return when(this){
        is Activity -> this
        is ContextWrapper -> this.baseContext.getActivity()
        else -> null
    }
}
