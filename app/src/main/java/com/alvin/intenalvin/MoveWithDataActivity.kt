package com.alvin.intenalvin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveWithDataActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvDataReceved : TextView
    private lateinit var btnBack1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        tvDataReceved = findViewById(R.id.tv_data_receiver)
        DataRecevide()

        btnBack1 = findViewById(R.id.btn_back1)
        btnBack1.setOnClickListener(this)

    }

    private fun DataRecevide() {
        val bundle = intent.extras
        var nama = bundle?.getString("Nama")
        var alamat = bundle?.getString("Alamat")

        tvDataReceved.text = nama + " " + alamat
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.btn_back1 -> run {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}