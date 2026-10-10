package com.example.suci_mobile.Pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.suci_mobile.MainActivity
import com.example.suci_mobile.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Akses SharedPreferences untuk mengecek status login
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        // Menggunakan coroutine lifecycleScope untuk jeda waktu splash screen
        lifecycleScope.launch {
            delay(2000) // Simulasi jeda waktu selama 2 detik

            // Pengecekan kondisi isLogin
            val intent = if (isLogin) {
                Intent(this@SplashScreenActivity, MainActivity::class.java)
            } else {
                Intent(this@SplashScreenActivity, AuthActivity::class.java)
            }

            startActivity(intent)
            finish() // Menutup SplashScreen agar tidak bisa di-back kembali
        }
    }
}