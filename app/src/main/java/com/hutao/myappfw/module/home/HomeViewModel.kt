package com.hutao.myappfw.module.home

import android.text.format.DateFormat
import androidx.lifecycle.viewModelScope
import com.hutao.myappfw.base.list.base.BaseRecyclerViewModel
import com.hutao.myappfw.base.list.base.BaseViewData
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.item.Test1ViewData
import com.hutao.myappfw.item.Test2ViewData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.module.home
 * @ClassName: HomeViewModel
 * @Description: 类作用描述
 * @Author: hutao
 * @CreateDate: 2021/10/23 17:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 17:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class HomeViewModel : BaseRecyclerViewModel(){
    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {
            // 模拟网络数据加载
            delay(1000L)

            val time = DateFormat.format("MM-dd HH:mm:ss", System.currentTimeMillis())

            var viewDataList : List<BaseViewData<*>>

            if (!isLoadMore) {
                //如果不是加载更多模式  就只设置一页假数据
                viewDataList = listOf<BaseViewData<*>>(
                    Test1ViewData("a-$time"),
                    Test2ViewData("b-$time"),
                    Test1ViewData("c-$time"),
                    Test2ViewData("d-$time"),
                    Test1ViewData("e-$time"),
                    Test2ViewData("f-$time"),
                    Test1ViewData("g-$time"),
                    Test2ViewData("h-$time"),
                )
            } else {
                // 在第5页模拟网络异常
                if (page == 5) {
                    postError(isLoadMore)
                    return@launch
                }
                viewDataList = listOf<BaseViewData<*>>(
                    Test1ViewData("a-$time"),
                    Test2ViewData("b-$time"),
                    Test1ViewData("c-$time"),
                    Test2ViewData("d-$time"),
                    Test1ViewData("e-$time"),
                    Test2ViewData("f-$time"),
                    Test1ViewData("g-$time"),
                    Test2ViewData("h-$time"),
                )
            }
            //发送数据更新UI
            postData(isLoadMore, viewDataList)
            // postError(isLoadMore)
        }

    }

    override fun getPageName() = PageName.HOME
}