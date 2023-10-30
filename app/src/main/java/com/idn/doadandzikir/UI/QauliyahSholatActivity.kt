package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikir.Model.DataDoaDzikir
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityQauliyahSholatBinding

class QauliyahSholatActivity : AppCompatActivity() {

    private var _binding : ActivityQauliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQauliyahSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityQauliyahSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val madapter = DoadanDzikirAdapter()
        madapter.setData(DataDoaDzikir.listDataQauliyah)
        binding.rvQauliyahSholat.adapter = madapter
        binding.rvQauliyahSholat.layoutManager = LinearLayoutManager(this)
    }
//    untuk kembali
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}