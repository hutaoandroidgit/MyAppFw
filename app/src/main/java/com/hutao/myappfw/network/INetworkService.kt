package com.hutao.myappfw.network

import com.hutao.myappfw.bean.VideoBean
import com.hutao.myappfw.network.base.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {

    @GET("videodetail")
    suspend fun requestVideoDetail(@Query("id") id: String): BaseResponse<VideoBean>
}