package com.catostudio.humanresource.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user : User) : Long

    @Update
    suspend fun update(user: User) : Int

    @Query("SELECT * FROM user_table WHERE id_user = :id")
    fun getUser(id: Long) : User?

    @Query("SELECT * FROM user_table ORDER BY id_user DESC LIMIT 1")
    fun getFirstUser(): User?

   /* @Query("DELETE FROM user")
    suspend fun clear()*/

    @Query("SELECT  * FROM user_table")
    fun getAllUser(): LiveData<List<User>>


}
