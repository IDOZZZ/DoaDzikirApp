package com.idn.doadandzikir.UI.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityDzikirPagiBinding
import com.idn.doadandzikir.databinding.ActivityPagiPetangDzikirBinding

class DzikirPagiActivity : AppCompatActivity(){
    private var _binding : ActivityDzikirPagiBinding? = null
    private val binding get() = _binding as ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "dzikir Pagi"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        _binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvDzikirPagi.apply {
            val mAdapter = DoadanDzikirAdapter()
            mAdapter.setData(DataDoaDzikir.listDzikirPagi)
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