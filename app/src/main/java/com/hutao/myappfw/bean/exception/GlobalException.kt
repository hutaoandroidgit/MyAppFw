package com.hutao.myappfw.bean.exception

import java.lang.RuntimeException

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.bean.exception
 * @ClassName: GlobalException
 * @Description: 全局运行时异常打印类
 *              继承RuntimeException
 * @Author: hutao
 * @CreateDate: 2021/10/24 0:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 0:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class GlobalException private constructor(message : String) : RuntimeException(message){
    companion object{
        @JvmStatic
        fun of(message: String) = GlobalException(message)
    }
}