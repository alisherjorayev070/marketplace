package com.example.marketplace

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.marketplace.data.Data
import com.example.marketplace.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

const val TAG = "SplashActivity"

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
//    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Data.initProducts()

        Handler()
            .postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 2000)

    }

}