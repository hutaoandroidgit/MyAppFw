package com.hutao.myappfw.network

import com.hutao.myappfw.network.base.BaseNetworkApi

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.network
 * @ClassName: NetworkApi
 * @Description: 网络请求具体实现
 * @Author: hutao
 * @CreateDate: 2021/10/24 15:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 15:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
object NetworkApi : BaseNetworkApi<INetworkService>("http://172.16.47.112:8080/XArchServer/"){
    /**
     * kotlin协程方法请求视频数据
     * @param id String
     * @return [ERROR : Error function type]
     */
    suspend fun requestVideoDetail(id: String) = getResult{
        service.requestVideoDetail(id)
    }

}