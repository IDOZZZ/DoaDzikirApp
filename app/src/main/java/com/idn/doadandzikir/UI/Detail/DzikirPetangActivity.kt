package com.idn.doadandzikir.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityDzikirPagiBinding
import com.idn.doadandzikir.databinding.ActivityDzikirPetangBinding

class DzikirPetangActivity : AppCompatActivity() {
    var _binding : ActivityDzikirPetangBinding? = null
    private val binding get() = _binding as ActivityDzikirPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "dzikir Petang"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPetang)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    //    untuk kembali
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
    }
