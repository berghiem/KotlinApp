package com.catostudio.humanresource.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User (

    @PrimaryKey(autoGenerate = true)
    var id_user : Int = 0,

    @ColumnInfo(name = "username")
    var username : String= "",

    @ColumnInfo(name = "fullname")
    var fullname : String = "",

    @ColumnInfo(name = "email")
    var email : String = "",

    @ColumnInfo(name = "no_hp")
    var no_hp : String = "",

    @ColumnInfo(name = "address")
    var address : String = "",

    @ColumnInfo(name = "id_role")
    var id_role : String = "",

    @ColumnInfo(name = "join_date")
    var join_date : Long = System.currentTimeMillis(),

    @ColumnInfo(name = "profile_picture")
    var profile_picture : String = "",

    @ColumnInfo(name = "password")
    var password : String = ""
){

}