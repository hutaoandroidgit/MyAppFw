package com.hutao.myappfw.constant

import androidx.annotation.StringDef

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.constant
 * @ClassName: PageName
 * @Description: 页面名称注解类
 * @Author: hutao
 * @CreateDate: 2021/10/22 15:48
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/22 15:48
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@StringDef(PageName.MAIN, PageName.HOME, PageName.ACGN, PageName.SMALL_VIDEO, PageName.GOLD, PageName.MINE)
@Retention(AnnotationRetention.SOURCE)
annotation class PageName {
    companion object {
        const val MAIN = "main"
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        const val GOLD = "gold"
        const val MINE = "mine"
    }
}