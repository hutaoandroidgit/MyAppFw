package com.hutao.myappfw.persistence.database.dao

import androidx.room.*
import com.hutao.myappfw.bean.User

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw.persistence.database.dao
 * @ClassName: UserDao
 * @Description: user数据库查询等操作方法封装接口 dao
 * @Author: hutao
 * @CreateDate: 2021/10/24 14:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/10/24 14:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)
}