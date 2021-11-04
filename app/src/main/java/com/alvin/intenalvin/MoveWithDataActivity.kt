package com.alvin.intenalvin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity() {
    private lateinit var tvDataReceved : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvDataReceved = findViewById(R.id.tv_data_receiver)
        DataRecevide()

    }

    private fun DataRecevide() {
        val bundle = intent.extras
        var nama = bundle?.getString("Nama")
        var alamat = bundle?.getString("Alamat")

        tvDataReceved.text = nama + " " + alamat
    }
}