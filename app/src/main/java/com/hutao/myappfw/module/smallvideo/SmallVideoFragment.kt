package com.hutao.myappfw.module.smallvideo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hutao.myappfw.R
import com.hutao.myappfw.base.BaseFragment
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.databinding.FragmentSmallVideoBinding

/**
 * 小视频
 */
class SmallVideoFragment : BaseFragment() {

    private val viewModel: SmallVideoViewModel by viewModels()
    private lateinit var viewBinding: FragmentSmallVideoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = FragmentSmallVideoBinding.inflate(inflater, container, false)
        initView()
        return viewBinding.root
    }

    private fun initView() {
        viewModel.helloWorldLiveData.observe(viewLifecycleOwner) {
            val video = it.getOrNull()
            if (null != video) {
                viewBinding.tvHello.text = "${video.id}-${video.title}"
            } else {
                viewBinding.tvHello.text = resources.getString(R.string.page_state_network_error)
            }
        }
        viewModel.requestVideoDetail("100")
    }

    @PageName
    override fun getPageName() = PageName.SMALL_VIDEO

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        // 这里可以添加页面打点
    }
}