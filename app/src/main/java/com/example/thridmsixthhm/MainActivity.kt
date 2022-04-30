package com.example.thridmsixthhm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.thridmsixthhm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var launchForResult = registerForActivityResult(
        StartActivityForResult(),
        ActivityResultCallback<ActivityResult> { result ->
            if (result.resultCode === RESULT_OK) {
                val text =result.data?.getStringExtra("result")
                binding.etValue.setText(text)
                // your operation....
            }
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSend.setOnClickListener {
            if (binding.etValue.text.isNotEmpty()) {
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("key.fy",binding.etValue.text.toString())
                launchForResult.launch(intent)
            } else {
                Toast.makeText(this, "Edit text can not be empty", Toast.LENGTH_LONG).show()
            }
        }
    }
}