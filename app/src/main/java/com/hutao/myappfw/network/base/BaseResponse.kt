package com.hutao.myappfw.network.base

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.network.base
 * @ClassName: BaseResponse
 * @Description: 网络数据返回类
 * @Author: hutao
 * @CreateDate: 2021/10/24 16:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 16:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
data class BaseResponse<T>(
    var code : Int = 0,
    var msg : String? = null ,
    var redirect : String? = null ,
    var value : T? = null
)
