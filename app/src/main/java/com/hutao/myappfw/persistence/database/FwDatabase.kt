package com.hutao.myappfw.persistence.database

import androidx.room.*
import com.hutao.myappfw.FwApplication
import com.hutao.myappfw.bean.User
import com.hutao.myappfw.persistence.database.dao.UserDao

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.persistence.database
 * @ClassName: FwDataBase
 * @Description: 数据库DataBase 继承RoomDataBase
 * @Author: hutao
 * @CreateDate: 2021/10/24 14:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 14:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Database(entities = [User::class] , version = 1)
abstract class FwDatabase : RoomDatabase(){
    abstract fun userDao() : UserDao

    companion object{
        /**
         * 创建数据库
         */
        private val db : FwDatabase by lazy {
            Room.databaseBuilder(
                FwApplication.instant,
                FwDatabase :: class.java , "database-name"
            ).build()
        }

        /**
         * 获取当前数据库dao查询方法
         * @return UserDao
         */
        fun userDao() : UserDao{
            return db.userDao()
        }
    }

}