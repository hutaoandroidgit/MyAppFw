package com.hutao.myappfw.module.main

import com.hutao.myappfw.base.BaseViewModel
import com.hutao.myappfw.constant.PageName

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.module.main
 * @ClassName: MainViewModel
 * @Description: MainActivity 对应 ViewModel
 * @Author: hutao
 * @CreateDate: 2021/10/22 21:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 21:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
class MainViewModel : BaseViewModel(){
    override fun getPageName(): String = PageName.MAIN;
}