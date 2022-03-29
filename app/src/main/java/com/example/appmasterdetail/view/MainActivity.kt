package com.example.appmasterdetail.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.appmasterdetail.databinding.ActivityMainBinding
import com.example.appmasterdetail.model.ApiService
import com.example.appmasterdetail.model.UserModel
import com.example.appmasterdetail.viewmodel.UserAdapterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userList: UserModel
    private val viewModel: UserAdapterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userAdapterViewModel = UserAdapterViewModel()
        binding.layout.setOnClickListener {
            userAdapterViewModel.apiCall()
        }

        viewModel.userMutableLiveData.observe(this, Observer {
            val recyclerView = binding.recycler
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = UserAdapter(it.results)
        })
//        consulta()
    }

//    private fun initRecyclerView() {
//        val recyclerView = binding.recycler
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = UserAdapter(userList.results)
//    }

//    private fun consulta() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val call = Retrofit.Builder()
//                .baseUrl("https://randomuser.me/api/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ApiService::class.java).getRandomUsers("./?results=50")
//
//            userList = call.body()!!
//            runOnUiThread {
//
//                if (call.isSuccessful) {
////                    showMessage(userList.results.size.toString())
//                    initRecyclerView()
//                } else {
////                    showMessage("Ha ocurrido un error")
//                }
//            }
//        }
//    }
}