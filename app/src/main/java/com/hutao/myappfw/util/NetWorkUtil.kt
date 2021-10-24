package com.hutao.myappfw.util

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import com.hutao.myappfw.FwApplication

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.util
 * @ClassName: NetWorkUtil
 * @Description: 网络相关函数扩展
 * @Author: hutao
 * @CreateDate: 2021/10/23 17:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 17:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
/**
 * 返回当期网络连接状态
 * @return Boolean
 */
fun isNetworkConnect() : Boolean{
    val cm = FwApplication.instant.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo?.isAvailable ?: false
}

/**
 * 跳转设置wifi界面
 * @param context Context
 */
fun toNetworkSetting(context: Context){
    val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
    context.startActivity(intent)
}

