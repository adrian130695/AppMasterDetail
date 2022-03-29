package com.example.appmasterdetail.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appmasterdetail.model.ApiService
import com.example.appmasterdetail.model.UserModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserAdapterViewModel(application: Application) : AndroidViewModel(application) {

    var userMutableLiveData: MutableLiveData<UserModel> = MutableLiveData()

    init {
        apiCall()
    }

    fun apiCall() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("apiCall1", userMutableLiveData.toString())
            val call = Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java).getRandomUsers("./?results=50")

            userMutableLiveData.postValue(call.body())
            Log.d("apiCall2", userMutableLiveData.toString())
        }
    }

}