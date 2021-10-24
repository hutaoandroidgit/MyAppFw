package com.hutao.myappfw.module.acgn

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
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.databinding.FragmentAcgnBinding

/**
 * 二次元
 */
class AcgnFragment : BaseFragment() {

    private val viewModel: AcgnViewModel by viewModels()
    private lateinit var viewBinding: FragmentAcgnBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = FragmentAcgnBinding.inflate(inflater, container, false)
        initView()
        return viewBinding.root
    }

    private fun initView() {
        viewBinding.rvList.init(
            FwRecyclerView.Config()
                .setViewModel(viewModel)
                .setPullRefreshEnable(false)
                .setPullUploadMoreEnable(false)
                .setOnItemClickListener(object : FwRecyclerView.OnItemClickListener {
                    override fun onItemClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long) {
                        Toast.makeText(context, "条目点击: ${viewData.value}", Toast.LENGTH_SHORT).show()
                    }
                })
                .setOnItemChildViewClickListener(object : FwRecyclerView.OnItemChildViewClickListener {
                    override fun onItemChildViewClick(parent: RecyclerView, view: View, viewData: BaseViewData<*>, position: Int, id: Long, extra: Any?) {
                        if (extra is String) {
                            Toast.makeText(context, "条目子View点击: $extra", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        )
    }

    @PageName
    override fun getPageName() = PageName.ACGN

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}