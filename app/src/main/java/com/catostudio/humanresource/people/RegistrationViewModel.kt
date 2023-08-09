package com.catostudio.humanresource.people

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.catostudio.humanresource.database.User
import com.catostudio.humanresource.database.UserDao
import com.catostudio.humanresource.formatUsers
import kotlinx.coroutines.launch

class RegistrationViewModel (
    val database: UserDao ,
    application : Application) : AndroidViewModel(application){

         var user = MutableLiveData<User?>()
         var username = MutableLiveData<String>()
         var password = MutableLiveData<String>()
         var users = database.getAllUser()
         val userString = Transformations.map(users){
             users -> formatUsers(users, application.resources)
         }



    fun onRegistration(user : User){
        viewModelScope.launch{
             insert(user)
        }
    }

    fun addNewUser(username: String, password: String){
        val newUser = getNewUserEntry(username, password)
        onRegistration(newUser)
    }

    private suspend fun insert( newUser : User){
        database.insert(newUser)
    }

    private fun getNewUserEntry(username : String, password: String) : User{
        return User(
            username = username,
            password =  password
        )
    }



}