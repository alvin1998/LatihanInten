package com.alvin.intenalvin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.Touch
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.log
import android.util.Log.i as i1

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDealNumber: Button
    private lateinit var btnMoveForResult: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        WarnaRecevide()

        btnMoveActivity = findViewById(R.id.btn_movr_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_movr_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDealNumber = findViewById(R.id.btn_dial_number)
        btnDealNumber.setOnClickListener(this)

        btnMoveForResult = findViewById(R.id.btn_result_from_activity)
        btnMoveForResult.setOnClickListener(this)

    }

    private fun WarnaRecevide() {
        val bundle = intent.extras
        var warna = bundle?.getString("Warna")
        tvResult.text = warna
    }

    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){
                R.id.btn_movr_activity -> run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_movr_with_data -> run {
                    val intent = Intent(this, MoveWithDataActivity::class.java)
                    val bundle = Bundle()
                    bundle.putString("Nama" , "Alvin")
                    bundle.putString("Alamat" , "Malang")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial_number -> run {
                    var dialNumber = "081230235573"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_result_from_activity -> run {
                    val intent = Intent(this, MoveForResultActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

}
