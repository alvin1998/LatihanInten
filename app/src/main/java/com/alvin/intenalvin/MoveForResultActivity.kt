package com.alvin.intenalvin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.google.android.material.snackbar.Snackbar

class MoveForResultActivity : AppCompatActivity() {

    var RgColor : RadioGroup? = null
    private lateinit var radioButton: RadioButton
    private lateinit var btnPilih: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        RgColor = findViewById(R.id.rg_color)
        btnPilih = findViewById(R.id.btn_choose)

        btnPilih.setOnClickListener {

            val SelectOption: Int = RgColor!!.checkedRadioButtonId

            Log.i("coba", SelectOption.toString())

            if(SelectOption == -1){
                Snackbar.make(
                    btnPilih,
                    "Anda Belom Memilih",
                    Snackbar.LENGTH_SHORT
                ).show()
            }else{
                radioButton = findViewById(SelectOption)
            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Warna", radioButton.text as  String?)
            intent.putExtras(bundle)
            startActivity(intent)

            }

        }

    }

}