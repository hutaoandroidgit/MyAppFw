package com.hutao.myappfw.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.base
 * @ClassName: BaseViewModel
 * @Description: ViewModel基类
 * @Author: hutao
 * @CreateDate: 2021/10/22 17:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 17:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
abstract class BaseViewModel : ViewModel() , IGetPageName{

    private val compositeDisposable = CompositeDisposable();

    /**
     * ViewModel 在cleared方法取消订阅
     */
    override fun onCleared() {
        compositeDisposable.dispose();
        super.onCleared()
    }

    protected fun addDisposable(disposable: Disposable){
        compositeDisposable.add(disposable);
    }
}