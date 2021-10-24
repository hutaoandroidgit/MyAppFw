package com.hutao.myappfw.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.hutao.myappfw.R
import com.hutao.myappfw.databinding.ViewLoadingBinding

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.widget
 * @ClassName: LoadingView
 * @Description: 加载控件
 * @Author: hutao
 * @CreateDate: 2021/10/23 18:05
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 18:05
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class LoadingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr)  {
    val viewBinding =  ViewLoadingBinding.inflate(LayoutInflater.from(context),this,true).apply {
        viewLoading.setViewColor(resources.getColor(R.color.theme_color))
    }

    /**
     * 重写改方法启动关闭动画
     * @param visibility Int
     */
    override fun setVisibility(visibility: Int) {
        super.setVisibility(visibility)
        if (visibility == View.VISIBLE) {
            viewBinding.viewLoading.startAnim()
        } else {
            viewBinding.viewLoading.stopAnim()
        }
    }

    /**
     * 重写该方法在view解除Window绑定 关闭动画
     */
    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}