package com.example.thridmsixthhm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thridmsixthhm.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("key.fy")
        binding.etValue.setText(text)

        initListeners()
    }

    private fun initListeners() {
        binding.btnSend.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result",binding.etValue.text.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}