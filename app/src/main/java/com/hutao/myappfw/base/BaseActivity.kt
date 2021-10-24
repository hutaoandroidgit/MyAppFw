package com.hutao.myappfw.base

import android.os.Bundle
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.base
 * @ClassName: BaseActivity
 * @Description: Activity基类  继承SwipeBackActivity 再继承AppCompatActivity 无兼容问题
 *              实现IGetPageName接口 获取页面名称通用接口
 * @Author: hutao
 * @CreateDate: 2021/10/22 13:17
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 13:17
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseActivity : SwipeBackActivity() , IGetPageName{

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSwipeBackEnable(swipeBackEnable())
    }

    override fun onResume() {
        super.onResume()
        // 这里可以添加页面打印
    }

    override fun onStart() {
        super.onStart()
        // 这里可以添加页面打印
    }

    override fun onStop() {
        super.onStop()
        // 这里可以添加页面打印
    }

    override fun onPause() {
        super.onPause()
        // 这里可以添加页面打印
    }

    /**
     * 自动取消Rxjava的订阅
     */
    override fun onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy()
        // 这里可以添加页面打印
    }

    /**
     * 默认开启左滑关闭界面 ，不需要 子类可以继承重写
     * @return Boolean
     */
    protected open fun swipeBackEnable(): Boolean = true

    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    protected fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }

}