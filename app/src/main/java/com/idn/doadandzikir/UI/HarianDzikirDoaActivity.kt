package com.idn.doadandzikir.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.doadandzikir.Adapter.DoadanDzikirAdapter
import com.idn.doadandzikir.Model.DoadanDzikirItem
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityHarianDzikirDoaBinding

class HarianDzikirDoaActivity : AppCompatActivity() {
    private var _binding :ActivityHarianDzikirDoaBinding? = null
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        providingDzikirData()
        initView()
    }
    private fun  initView() {
        val meAdapter = DoadanDzikirAdapter()
        meAdapter.setData(providingDzikirData())
        binding.rvDzikirDoaHarian.adapter = meAdapter
        binding.rvDzikirDoaHarian.layoutManager = LinearLayoutManager(this)
    }
    private fun providingDzikirData():List<DoadanDzikirItem> {

        val judulDoa = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val isiDoa = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemahDoa = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)


        val listData = arrayListOf<DoadanDzikirItem>()
        for (i in judulDoa.indices) {
            val data = DoadanDzikirItem(
                judulDoa[i],
                isiDoa[i],
                terjemahDoa[i]
            )
            listData.add(data)
        }
        return listData
    }

    //    untuk kembali
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}
