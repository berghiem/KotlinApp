package com.catostudio.humanresource.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class BookstoreDatabase : RoomDatabase(){
    abstract val userDao : UserDao
    companion object {
        @Volatile
        private var INSTANCE : BookstoreDatabase? = null
        fun getInstance(context : Context) : BookstoreDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance =
                        Room.databaseBuilder (context.applicationContext,BookstoreDatabase::class.java,"bookstore").fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}