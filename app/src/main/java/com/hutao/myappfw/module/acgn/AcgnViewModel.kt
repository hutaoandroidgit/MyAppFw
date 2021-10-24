package com.hutao.myappfw.module.acgn

import androidx.lifecycle.viewModelScope
import com.hutao.myappfw.base.list.base.BaseRecyclerViewModel
import com.hutao.myappfw.bean.User
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.item.Test3ViewData
import com.hutao.myappfw.persistence.database.FwDatabase
import kotlinx.coroutines.launch

class AcgnViewModel : BaseRecyclerViewModel() {

    override fun needNetwork(): Boolean {
        return false
    }

    override fun loadData(isLoadMore: Boolean, isReLoad: Boolean, page: Int) {
        viewModelScope.launch {
            // 模拟插入一些数据
            FwDatabase.userDao().insert(
                listOf(
                    User(1, "吴", "一", null),
                    User(2, "黄", "二", null),
                    User(3, "李", "三", null),
                    User(4, "张", "四", null),
                    User(5, "林", "五", null),
                    User(6, "吴", "六", null),
                    User(7, "黄", "七", null),
                    User(8, "李", "八", null),
                    User(9, "张", "九", null),
                    User(10, "林", "十", null),
                )
            )

            // 从数据库加载数据
            val viewData = mutableListOf<Test3ViewData>()
            FwDatabase.userDao().getAll().forEach {
                viewData.add(Test3ViewData(it))
            }
            postData(isLoadMore, viewData)
        }
    }

    @PageName
    override fun getPageName() = PageName.ACGN

}