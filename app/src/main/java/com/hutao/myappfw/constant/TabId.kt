package com.hutao.myappfw.constant

import androidx.annotation.StringDef

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.constant
 * @ClassName: Table
 * @Description: 底栏id
 * @Author: hutao
 * @CreateDate: 2021/10/23 16:37
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/23 16:37
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@StringDef(TabId.HOME, TabId.ACGN, TabId.SMALL_VIDEO, TabId.GOLD, TabId.MINE)
@Retention(AnnotationRetention.SOURCE)
annotation class TabId {
    companion object{
        const val HOME = "home"
        const val ACGN = "acgn"
        const val SMALL_VIDEO = "small_video"
        const val GOLD = "gold"
        const val MINE = "mine"
    }
}