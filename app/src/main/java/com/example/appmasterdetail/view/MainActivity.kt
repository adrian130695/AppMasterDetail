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
    private val viewModel: UserAdapterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.userMutableLiveData.observe(this) {
            val recyclerView = binding.recycler
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = UserAdapter(it.results)
        }
    }
}