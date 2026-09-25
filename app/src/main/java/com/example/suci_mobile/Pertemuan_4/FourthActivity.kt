package com.example.suci_mobile.Pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat
import com.example.suci_mobile.MainActivity
import com.example.suci_mobile.Pertemuan_3.ThirdResultActivity
import com.example.suci_mobile.R
import com.example.suci_mobile.databinding.ActivityFourthBinding
import com.example.suci_mobile.databinding.ActivityThirdBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
//        setContentView(R.layout.activity_third)
            binding = ActivityFourthBinding.inflate(layoutInflater)
            setContentView(binding.root)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            // Inisialisasi komponen
//        val inputNama: EditText = findViewById(R.id.inputNama)
//        val btnSubmit: Button = findViewById(R.id.btnSubmit)


            val name = intent.getStringExtra("name")
            val from = intent.getStringExtra("from")
            val age = intent.getIntExtra("age",0)
            Log.e("Data Intent","Nama: $name , Usia: $age, Asal: $from")

            binding.button.setOnClickListener {
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
                //Mengambil value dari inputNama dan menampilkan di Logcat
            }
            binding.btnShowSnackbar.setOnClickListener {
                Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                    .setAction("Tampilkan") {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        Log.e("Info Snackbar", "Snackbar ditutup")
                    }
                    .show()
            }
            binding.btnShowAlertDialog.setOnClickListener {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Konfirmasi")
                    .setMessage("Apakah Anda yakin ingin melanjutkan?")
                    .setPositiveButton("Ya") { dialog, _ ->
                        dialog.dismiss()
                        Log.e("Info Dialog","Anda memilih Ya!")
                    }
                    .setNegativeButton("Batal") { dialog, _ ->
                        dialog.dismiss()
                        Log.e("Info Dialog","Anda memilih Tidak!")
                    }
                    .show()
            }
        }
    }
