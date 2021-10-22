package com.hutao.myappfw.base

import com.hutao.myappfw.constant.PageName

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.base
 * @ClassName: IGetPageName
 * @Description: 获取页面名称通用接口
 * @Author: hutao
 * @CreateDate: 2021/10/22 15:47
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 15:47
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
interface IGetPageName {
    @PageName
    fun getPageName() : String
}