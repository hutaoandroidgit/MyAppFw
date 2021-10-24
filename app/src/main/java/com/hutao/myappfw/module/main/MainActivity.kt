package com.hutao.myappfw.module.main

import android.os.Bundle
import androidx.activity.viewModels
import com.gyf.immersionbar.ktx.immersionBar
import com.hutao.myappfw.R
import com.hutao.myappfw.base.BaseActivity
import com.hutao.myappfw.bean.Tab
import com.hutao.myappfw.constant.PageName
import com.hutao.myappfw.constant.TabId
import com.hutao.myappfw.databinding.ActivityMainBinding
import com.hutao.myappfw.module.acgn.AcgnFragment
import com.hutao.myappfw.module.gold.GoldFragment
import com.hutao.myappfw.module.home.HomeFragment
import com.hutao.myappfw.module.mine.MineFragment
import com.hutao.myappfw.module.smallvideo.SmallVideoFragment
import com.hutao.myappfw.widget.NavigationView
import com.hutao.myappfw.widget.TabIndicatorView

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.module.main
 * @ClassName: MainActivity
 * @Description: 主页类
 * @Author: hutao
 * @CreateDate: 2021/10/22 21:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 21:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MainActivity : BaseActivity(){
    //获取当前对应的ViewModel
    private val viewModel : MainViewModel by viewModels()
    //当前布局的DateBinding
    private lateinit var viewBinding : ActivityMainBinding

    @TabId
    private var currentTabId = TabId.HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //固定写法 当前布局转化为binding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        initSystemBar()
        updateTitle()
        initTabs()
    }

    /**
     * 初始化底栏
     */
    private fun initTabs() {
        val tabs = listOf(
            Tab(TabId.HOME, getString(R.string.page_home), R.drawable.selector_btn_home, HomeFragment::class),
            Tab(TabId.SMALL_VIDEO, getString(R.string.page_small_video), R.drawable.selector_btn_small_video, SmallVideoFragment::class),
            Tab(TabId.ACGN, getString(R.string.page_acgn), R.drawable.selector_btn_acgn, AcgnFragment::class),
            Tab(TabId.GOLD, getString(R.string.page_gold), R.drawable.selector_btn_gold, GoldFragment::class),
            Tab(TabId.MINE, getString(R.string.page_mine), R.drawable.selector_btn_mine, MineFragment::class)
        )
        viewBinding.fragmentTabHost.run {
            // 调用setup()方法，设置FragmentManager，以及指定用于装载Fragment的布局容器
            setup(this@MainActivity, supportFragmentManager, viewBinding.fragmentContainer.id)
            tabs.forEach {
                val (id, title, icon, fragmentClz) = it
                val tabSpec = newTabSpec(id).apply {
                    setIndicator(TabIndicatorView(this@MainActivity).apply {
                        viewBinding.tabIcon.setImageResource(icon)
                        viewBinding.tabTitle.text = title
                    })
                }
                addTab(tabSpec, fragmentClz.java, null)
            }

            setOnTabChangedListener { tabId ->
                currentTabId = tabId
                updateTitle()
            }
        }
    }

    /**
     * 更新导航栏标题
     */
    private fun updateTitle() {
        var title = when(currentTabId){
            TabId.HOME -> getString(R.string.page_home)
            TabId.SMALL_VIDEO -> getString(R.string.page_small_video)
            TabId.ACGN -> getString(R.string.page_acgn)
            TabId.GOLD -> getString(R.string.page_gold)
            TabId.MINE -> getString(R.string.page_mine)
            else -> ""
        }
        viewBinding.navigationBar.setParameter(
            NavigationView.ParameterBuilder()
                .setShowBack(false)
                .setShowTitle(true)
                .setTitle(title)
        )
    }

    /**
     * 沉浸式状态栏状态初始化
     */
    private fun initSystemBar() {
        immersionBar {
            transparentStatusBar()
            statusBarDarkFont(true)
            navigationBarColor(R.color.white)
            navigationBarDarkIcon(true)
        }
    }

    /**
     * 当前底栏 id
     * @return String
     */
    override fun getPageName(): String  = PageName.MAIN

    /**
     * 重写父类方法禁止左滑
     * @return Boolean
     */
    override fun swipeBackEnable() = false
}