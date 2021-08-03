package com.example.sharenativo

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.sharenativo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val shared = intent.action
        if (shared == Intent.ACTION_SEND) {

        }

        binding.btShare.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL, "Olá, estou com um problema e gostaria de uma solução")
                putExtra(Intent.EXTRA_SUBJECT, "Suporte ao usuário")
                putExtra(Intent.EXTRA_CC, "cnascimento@digitalhouse.com")
                putExtra(Intent.EXTRA_BCC, "lucas@digitalhouse.com")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(intent, "Compartilhe nosso app")
            startActivity(shareIntent)
        }


    }

}