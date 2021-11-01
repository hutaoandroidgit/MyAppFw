package com.hutao.myappfw

import android.app.Application
import android.content.Context
import com.hutao.myappfw.persistence.FwKeyValue

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw
 * @ClassName: FwApplication
 * @Description: 应用application实例
 * @Author: hutao
 * @CreateDate: 2021/10/22 11:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 11:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class FwApplication : Application(){

    /**
     * 单例模式：静态instant
     */
    companion  object{
        lateinit var instant : Application
    }

    /**
     * 继承ContextWrapper 这里装饰着模式 传入来Context实例ContextImpl
     * mApplication 是在attachBaseContext 之后 才被赋值
     * @param base Context
     */
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        instant = this
        //应用初始化操作
        //初始化MMKV
        FwKeyValue.init(this);
    }
}