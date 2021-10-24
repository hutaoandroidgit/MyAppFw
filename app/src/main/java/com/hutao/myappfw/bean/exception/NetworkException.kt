package com.hutao.myappfw.bean.exception

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.bean.exception
 * @ClassName: NetworkException
 * @Description: 网络异常打印类
 * @Author: hutao
 * @CreateDate: 2021/10/24 16:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 16:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class NetworkException private constructor(val code: Int, message: String) : RuntimeException(message) {

    override fun toString(): String {
        return "exception code is $code msg is $message"
    }

    companion object {
        @JvmStatic
        fun of(code: Int, message: String) = NetworkException(code, message)
    }

}