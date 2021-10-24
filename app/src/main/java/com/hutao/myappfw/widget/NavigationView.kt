package com.hutao.myappfw.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.hutao.myappfw.databinding.ViewNavigationBinding
import com.hutao.myappfw.util.getActivity
import com.hutao.myappfw.util.toVisibility

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.widget
 * @ClassName: NavigationView
 * @Description: 顶部导航栏
 *               @JvmOverloads直接重载了布局的2个方法
 *               constructor 直接连写构造 在ConstraintLayout(context, attrs)传参
 * @Author: hutao
 * @CreateDate: 2021/10/23 0:16
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 0:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class NavigationView @JvmOverloads constructor(context: Context, attrs : AttributeSet?= null)
    : ConstraintLayout(context, attrs), View.OnClickListener{
    //开启DataBinding 直接对标布局
    private var viewBinding : ViewNavigationBinding = ViewNavigationBinding.inflate(
        LayoutInflater.from(context),this,true)
    init {
        viewBinding.run {
            //直接把ivback的点击事件传给NavigationView
            ivBack.setOnClickListener(this@NavigationView)
        }
    }
    override fun onClick(v: View?) {
        viewBinding.run {
            //判断点击View id
            when(v?.id){
                ivBack.id -> {
                    context.getActivity()?.finish()
                }
                else ->{
                }
            }
        }
    }


    /**
     * 设置导航栏状态参数
     * @param builder ParameterBuilder
     */
    fun setParameter(builder: ParameterBuilder) {
        val parameter = builder.build()
        viewBinding.run {
            ivBack.visibility = parameter.showBack.toVisibility()
            tvTitle.visibility = parameter.showTitle.toVisibility()
            tvTitle.text = parameter.title
        }
    }
    /**
     * 导航栏参数类（建造者模式）
     * @property showBack Boolean  是否显示返回按钮
     * @property showTitle Boolean  是否显示title
     * @property title String title内容
     */
    class ParameterBuilder{
        private var showBack = false
        private var showTitle = true
        private var title = ""

        fun setShowBack(showBack: Boolean) : ParameterBuilder{
            this.showBack = showBack;
            return this;
        }

        fun setShowTitle(showTitle: Boolean) : ParameterBuilder{
            this.showTitle = showTitle;
            return this;
        }

        fun setTitle(title: String) : ParameterBuilder{
            this.title = title;
            return this;
        }

        fun build() : Parameter{
            return Parameter(showBack,showTitle,title)
        }
    }

    /**
     * 只包含数据的类 kotlin自动有的get set
        equals()/hashCode()
        toString()方法
        componentN()方法
        copy()方法
     * @property showBack Boolean
     * @property showTitle Boolean
     * @property title String
     * @constructor
     */
    data class Parameter(
        var showBack: Boolean,
        var showTitle: Boolean,
        var title: String
    )


}