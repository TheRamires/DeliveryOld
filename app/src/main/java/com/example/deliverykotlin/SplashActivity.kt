package com.example.deliverykotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    private val splashViewModel : SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        splashViewModel.entityList()
        splashViewModel.firstParamList()
        splashViewModel.secondParamList()

        splashViewModel.splashCompleted.observe(this, {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}