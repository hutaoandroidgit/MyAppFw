package com.hutao.myappfw.network.base

import com.hutao.myappfw.BuildConfig
import com.hutao.myappfw.bean.exception.NetworkException
import com.hutao.myappfw.constant.ErrorCode
import com.hutao.myappfw.network.interceptor.CommonResponseInterceptor
import com.nan.xarch.network.interceptor.CommonRequestInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.util.concurrent.TimeUnit

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.network.base
 * @ClassName: BaseNewworkApi
 * @Description:网络请求封装 使用Retrofit okhttp 请求网络
 * @Author: hutao
 * @CreateDate: 2021/10/24 15:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 15:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseNetworkApi<I>(private val baseUrl:String) : IService<I>{

    protected val service : I by lazy {
        getRetrofit().create(getServiceClass())
    }

    /**
     * 获取参数化类型的第一个泛型参数类型
     * @return Class<I>
     */
    private fun getServiceClass(): Class<I>? {
        val genType = javaClass.genericSuperclass as ParameterizedType
        return genType.actualTypeArguments[0] as Class<I>
    }

    /**
     * Retrofit初始化build
     * @return Retrofit
     */
    protected open fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * 判断当前有没有设置过OkHttpClient参数
     * 没有就使用默认
     * @return OkHttpClient
     */
    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = getCustomOkHttpClient()
        if (null != okHttpClient) {
            return okHttpClient
        }
        return defaultOkHttpClient
    }

    protected open fun getCustomOkHttpClient(): OkHttpClient? {
        return null
    }

    protected open fun getCustomInterceptor(): Interceptor? {
        return null
    }

    protected suspend fun <T> getResult(block: suspend () -> BaseResponse<T>): Result<T> {
        for (i in 1..RETRY_COUNT) {
            try {
                val response = block()
                if (response.code != ErrorCode.OK) {
                    throw NetworkException.of(response.code, "response code not 200")
                }
                if (response.value == null) {
                    throw NetworkException.of(ErrorCode.VALUE_IS_NULL, "response value is null")
                }
                return Result.success(response.value) as Result<T>
            } catch (throwable: Throwable) {
                if (throwable is NetworkException) {
                    return Result.failure(throwable)
                }
                if ((throwable is HttpException && throwable.code() == ErrorCode.UNAUTHORIZED)) {
                    // 这里刷新token，然后重试
                }
            }
        }
        return Result.failure(NetworkException.of(ErrorCode.VALUE_IS_NULL, "unknown"))
    }


    /**
     * 静态代码
     */
    companion object {
        const val TAG = "BaseNetworkApi"
        private const val RETRY_COUNT = 2

        /**
         * 默认的okhttp配置
         */
        private val defaultOkHttpClient by lazy {
            val builder = OkHttpClient.Builder()
                .callTimeout(10L, TimeUnit.SECONDS)
                .connectTimeout(10L, TimeUnit.SECONDS)
                .readTimeout(10L, TimeUnit.SECONDS)
                .writeTimeout(10L, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
            /**
             * 设置请求头部 以及结果返回 拦截器
             */
            builder.addInterceptor(CommonRequestInterceptor())
            builder.addInterceptor(CommonResponseInterceptor())
            /**
             * 判断当前是时候是debug版本 添加http log
             */
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                builder.addInterceptor(loggingInterceptor)
            }

            builder.build()
        }
    }
}