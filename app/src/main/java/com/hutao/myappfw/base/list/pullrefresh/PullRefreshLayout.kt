package com.hutao.myappfw.base.list.pullrefresh

import `in`.srain.cube.views.ptr.PtrDefaultHandler
import `in`.srain.cube.views.ptr.PtrFrameLayout
import `in`.srain.cube.views.ptr.PtrUIHandler
import `in`.srain.cube.views.ptr.indicator.PtrIndicator
import android.content.Context
import android.util.AttributeSet
import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import com.hutao.myappfw.R
import com.hutao.myappfw.databinding.ViewRecyclerHeaderBinding
import com.hutao.myappfw.util.Logger
/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.base.list.pullrefresh
 * @ClassName: PullRefreshLayout
 * @Description: 下拉刷新控件
 * @Author: hutao
 * @CreateDate: 2021/10/23 18:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 18:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class PullRefreshLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PtrFrameLayout(context, attrs, defStyleAttr), PtrUIHandler {

    private val viewBinding = ViewRecyclerHeaderBinding.inflate(LayoutInflater.from(context), this, false)
    private var onPullRefreshListener: OnPullRefreshListener? = null

    companion object {
        private const val TAG = "PullRefreshLayout"
    }

    init {
        disableWhenHorizontalMove(true)
        isKeepHeaderWhenRefresh = true
        setRatioOfHeaderHeightToRefresh(1F)
        headerView = viewBinding.root
        addPtrUIHandler(this)
        setPtrHandler(
            object : PtrDefaultHandler() {
                override fun onRefreshBegin(layout: PtrFrameLayout) {
                    onPullRefreshListener?.onRefreshBegin()
                }
            })
    }

    override fun onUIReset(layout: PtrFrameLayout) {
        Logger.d(TAG, "onUIReset")
    }

    override fun onUIRefreshPrepare(layout: PtrFrameLayout) {
        Logger.d(TAG, "onUIRefreshPrepare")
        viewBinding.tvRefreshState.setText(R.string.refresh_pull_down_to_refresh)
    }

    override fun onUIRefreshBegin(layout: PtrFrameLayout) {
        Logger.d(TAG, "onUIRefreshBegin")
        viewBinding.tvRefreshState.setText(R.string.refresh_refreshing)
    }

    override fun onUIRefreshComplete(layout: PtrFrameLayout) {
        Logger.d(TAG, "onUIRefreshComplete")
        viewBinding.tvRefreshState.setText(R.string.refresh_refresh_complete)
    }

    override fun onUIPositionChange(layout: PtrFrameLayout, isUnderTouch: Boolean, status: Byte, ptrIndicator: PtrIndicator) {
        val offsetToRefresh: Int = layout.offsetToRefresh
        val currentPos = ptrIndicator.currentPosY
        val lastPos = ptrIndicator.lastPosY

        if (currentPos < offsetToRefresh && lastPos >= offsetToRefresh) {
            if (isUnderTouch && status == PTR_STATUS_PREPARE) {
                viewBinding.tvRefreshState.setText(R.string.refresh_pull_down_to_refresh)
            }
        } else if (currentPos > offsetToRefresh && lastPos <= offsetToRefresh) {
            if (isUnderTouch && status == PTR_STATUS_PREPARE) {
                viewBinding.tvRefreshState.setText(R.string.refresh_release_to_refresh)
                performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
            }
        }
    }

    fun setOnPullRefreshListener(listener: OnPullRefreshListener) {
        this.onPullRefreshListener = listener
    }

    interface OnPullRefreshListener {
        fun onRefreshBegin()
    }
}