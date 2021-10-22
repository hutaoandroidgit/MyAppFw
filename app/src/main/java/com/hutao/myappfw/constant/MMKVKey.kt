package com.hutao.myappfw.constant

import androidx.annotation.StringDef

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.constant
 * @ClassName: MMKVKey
 * @Description: MMKVKey 注解类 提供默认值
 * @Author: hutao
 * @CreateDate: 2021/10/22 15:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 15:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
//StringDef 字符串默认值为MMKVKey.TEST
@StringDef(MMKVKey.TEST)
//Retention 该注解的生命周期
@Retention(AnnotationRetention.SOURCE)
annotation class MMKVKey {
    companion object{
        const val TEST = "test"
    }
}