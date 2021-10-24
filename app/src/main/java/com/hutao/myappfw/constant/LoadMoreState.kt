package com.hutao.myappfw.constant

import androidx.annotation.IntDef

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.constant
 * @ClassName: LoadMoreState
 * @Description: 类作用描述
 * @Author: hutao
 * @CreateDate: 2021/10/23 18:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 18:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@IntDef(LoadMoreState.GONE, LoadMoreState.LOADING, LoadMoreState.ERROR, LoadMoreState.NO_NETWORK, LoadMoreState.NO_MORE)
@Retention(AnnotationRetention.SOURCE)
annotation class LoadMoreState {
    companion object {
        /**
         * 隐藏
         */
        const val GONE = 0

        /**
         * 正在加载
         */
        const val LOADING = 1

        /**
         * 加载异常
         */
        const val ERROR = 2

        /**
         * 无网络
         */
        const val NO_NETWORK = 3

        /**
         * 没有更多
         */
        const val NO_MORE = 4
    }
}