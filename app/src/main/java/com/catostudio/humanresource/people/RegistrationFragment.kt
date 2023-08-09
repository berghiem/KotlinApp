package com.catostudio.humanresource.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.catostudio.humanresource.R
import com.catostudio.humanresource.database.BookstoreDatabase
import com.catostudio.humanresource.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding  = DataBindingUtil.inflate<FragmentRegistrationBinding>(inflater, R.layout.fragment_registration, container,false)

        val application = requireNotNull(this.activity).application
        val datasource = BookstoreDatabase.getInstance(application).userDao
        val viewModelFactory = RegistrationViewModelFactory(datasource, application)
        val registrationViewModel = ViewModelProvider(this,viewModelFactory).get(RegistrationViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.registrationViewModel = registrationViewModel

         val adapter = UserAdapter()
        registrationViewModel.users.observe(viewLifecycleOwner , Observer {
            it?.let{
                adapter.data = it
            }
        })
        binding.userList.adapter = adapter

        val manager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        binding.userList.layoutManager = manager
        return binding.root
    }




}