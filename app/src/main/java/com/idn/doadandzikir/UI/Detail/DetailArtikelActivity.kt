package com.idn.doadandzikir.UI.Detail

import android.app.Activity
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.R
import com.idn.doadandzikir.databinding.ActivityDetailArtikelBinding

class DetailArtikelActivity : AppCompatActivity() {

    // Binding untuk tampilan
    private var _binding: ActivityDetailArtikelBinding? = null
    private val binding get() = _binding as ActivityDetailArtikelBinding

    // Konstanta untuk mengirim data melalui Intent
    companion object {
        const val DATA_TITLE = "title"
        const val DATA_DESC = "desc"
        const val DATA_IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // Menampilkan tombol kembali pada ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Mengatur judul halaman
        title = "Artikel islam"

        // Inisialisasi tampilan menggunakan binding
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data dari Intent
        val data = when {
            SDK_INT >= 33 -> intent.getParcelableExtra("data", Artikel::class.java)
            else -> @Suppress("DEPRECATION") intent.getParcelableExtra("data") as? Artikel
        }

        // Mengisi tampilan dengan data
        binding.apply {
            tvDetailTitle.text = data?.titleArtikel
            tvDetailDescription.text = data?.descArtikel
            data?.imageArtikel?.let { imgDetail.setImageResource(it) }
        }
    }

    // Menangani tombol kembali pada ActionBar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}
