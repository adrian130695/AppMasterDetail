package com.example.appmasterdetail.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.appmasterdetail.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = intent.getStringExtra("userName").toString()
        binding.tvPhone.text = intent.getStringExtra("userPhone").toString()
        binding.tvEmail.text = intent.getStringExtra("userEmail").toString()
        val picture = intent.getStringExtra("userPicture").toString()
        Glide.with(this).load(picture).into(binding.ivPhoto)
        var fav = false
        binding.ivFav.setOnClickListener {
            fav = !fav
            if (fav) {
                binding.ivFav.setColorFilter(Color.YELLOW)
            } else {
                binding.ivFav.setColorFilter(Color.GRAY)
            }

        }
    }
}