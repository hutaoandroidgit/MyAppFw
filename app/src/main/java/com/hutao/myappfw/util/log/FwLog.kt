package com.hutao.myappfw.util.log

import android.content.Context
import android.os.Environment
import com.apkfuns.log2file.LogFileEngineFactory
import com.apkfuns.logutils.LogLevel
import com.apkfuns.logutils.LogUtils
import com.apkfuns.logutils.file.LogFileFilter

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.persistence
 * @ClassName: FwLog
 * @Description: 打印初始化类
 * @Author: hutao
 * @CreateDate: 2021/11/3 14:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/3 14:35
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
object FwLog {
    fun init(context: Context){
        LogUtils.getLogConfig()
            .configAllowLog(true) // 是否在Logcat显示日志
            .configTagPrefix("LogUtilsDemo") // 配置统一的TAG 前缀
            .configFormatTag("%d{HH:mm:ss:SSS} %t %c{-5}") // 首行显示信息(可配置日期，线程等等)
            .configShowBorders(true) // 是否显示边框
            .configLevel(LogLevel.TYPE_VERBOSE) // 配置可展示日志等级
        // 支持输入日志到文件
        val filePath = Environment.getExternalStorageDirectory().toString() + "/LogUtils/logs/"
        LogUtils.getLog2FileConfig()
            .configLog2FileEnable(true) // 是否输出日志到文件
            .configLogFileEngine(LogFileEngineFactory(context)) // 日志文件引擎实现
            .configLog2FilePath(filePath) // 日志路径
            .configLog2FileNameFormat("app-%d{yyyyMMdd}.txt") // 日志文件名称
            .configLog2FileLevel(LogLevel.TYPE_VERBOSE) // 文件日志等级
            .configLogFileFilter { level, tag, logContent ->
                // 文件日志过滤
                true
            }
    }
}