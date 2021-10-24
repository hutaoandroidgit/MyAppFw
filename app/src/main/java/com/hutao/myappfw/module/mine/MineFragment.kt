package com.hutao.myappfw.module.mine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hutao.myappfw.base.BaseFragment
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.databinding.FragmentMineBinding

/**
 * 我的
 */
class MineFragment : BaseFragment() {

    private val viewModel: MineViewModel by viewModels()
    private lateinit var viewBinding: FragmentMineBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = FragmentMineBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    @PageName
    override fun getPageName() = PageName.MINE

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}