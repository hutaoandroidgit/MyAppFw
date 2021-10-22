package com.hutao.myappfw.base

import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.base
 * @ClassName: BaseFragment
 * @Description: Fragment基类
 * @Author: hutao
 * @CreateDate: 2021/10/22 17:14
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 17:14
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseFragment : Fragment() , IGetPageName{
    private val compositeDisposable = CompositeDisposable()

    /**
     * 自动取消Rxjava订阅
     */
    override fun onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy()
    }

    /**
     * 添加Disposadle
     * @param disposable Disposable
     */
    protected fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable)
    }
}