package com.catostudio.humanresource.people

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.catostudio.humanresource.database.UserDao

class RegistrationViewModelFactory
    (private val dataSource: UserDao,
     private val application: Application) : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RegistrationViewModel::class.java))
            return RegistrationViewModel(dataSource, application) as T
        throw java.lang.IllegalArgumentException("Unknown viewModel class")
    }


}