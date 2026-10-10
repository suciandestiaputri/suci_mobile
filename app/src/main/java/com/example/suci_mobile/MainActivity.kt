package com.example.suci_mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.suci_mobile.Pertemuan5.FifthActivity
import com.example.suci_mobile.Pertemuan_4.FourthActivity
import com.example.suci_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi SharedPreferences setelah setContentView
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            val i = Intent(this, FifthActivity::class.java)
            startActivity(i)
        }

        // Tombol Logout dengan AlertDialog & SharedPreferences clear
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar dari aplikasi?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Hapus status sesi login dari SharedPreferences
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    // Kembali ke halaman AuthActivity
                    val intent = Intent(this, com.example.suci_mobile.Pertemuan6.AuthActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        // Tombol menuju Halaman Profil Developer
        binding.btnToProfile.setOnClickListener {
            val intent = Intent(this, com.example.suci_mobile.Pertemuan6.ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}