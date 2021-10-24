package com.hutao.myappfw.module.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.hutao.myappfw.base.BaseFragment
import com.hutao.myappfw.base.list.FwRecyclerView
import com.hutao.myappfw.base.list.base.BaseViewData
import com.hutao.myappfw.constant.EventName
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.databinding.FragmentHomeBinding
import com.hutao.myappfw.eventbus.FwEventBus

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.module.home
 * @ClassName: HomeFragment
 * @Description: 首页Frg
 * @Author: hutao
 * @CreateDate: 2021/10/23 17:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 17:36
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class HomeFragment : BaseFragment(){
    /**
     * 获取当前viewmodel databinding
     * lateinit延迟加载 fragment 在onCreateView赋值
     */
    private val viewModel : HomeViewModel by viewModels()
    private lateinit var viewBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHomeBinding.inflate(inflater,container,false)
        initView()
        return viewBinding.root
    }

    private fun initView() {
        /**
         * 自定义列表布局初始化
         */
        viewBinding.rvList.init(FwRecyclerView.Config()
            .setViewModel(viewModel)
            .setOnItemClickListener(object : FwRecyclerView.OnItemClickListener{
                override fun onItemClick(
                    parent: RecyclerView,
                    view: View,
                    viewData: BaseViewData<*>,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT).show()
                }

            })
            .setOnItemChildViewClickListener(object : FwRecyclerView.OnItemChildViewClickListener{
                override fun onItemChildViewClick(
                    parent: RecyclerView,
                    view: View,
                    viewData: BaseViewData<*>,
                    position: Int,
                    id: Long,
                    extra: Any? //Any类似java的object
                ) {
                    if (extra is String) {
                        Toast.makeText(context, "条目子View点击: $extra", Toast.LENGTH_SHORT).show()
                    }
                }

            })
        )

        FwEventBus.observe(viewLifecycleOwner,EventName.REFRESH_HOME_LIST){ message :String ->
            viewBinding.rvList.refreshList()
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getPageName() = PageName.HOME

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        //这里可以添加打印
    }
}