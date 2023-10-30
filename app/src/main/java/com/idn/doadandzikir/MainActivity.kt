package com.idn.doadandzikir

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.idn.doadandzikir.Adapter.ArtikelAdapter
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.UI.Detail.DetailArtikelActivity
import com.idn.doadandzikir.UI.HarianDzikirDoaActivity
import com.idn.doadandzikir.UI.PagiPetangDzikirActivity
import com.idn.doadandzikir.UI.QauliyahSholatActivity
import com.idn.doadandzikir.UI.SetiapSaatDzikirActivity
import com.idn.doadandzikir.utills.OnItemCallback


class MainActivity : AppCompatActivity() {
    private var keep = true // Variabel untuk mengontrol penampilan splash screen.
    //private val runner = Runnable { keep = false } // Objek Runnable untuk menghentikan splash screen.


    private  val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            for ( i in 0 until listArtikel.size){
                sliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.dot_inactive))
            }
            sliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext,R.drawable.dot_active)
            )
        }

    }

    // Variabel lateinit untuk ViewPager2 dan Array of ImageView yang akan digunakan nanti.
    private lateinit var vpArtikel: ViewPager2
    private lateinit var sliderIndicator: Array<ImageView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginstal splash screen dari AndroidX Core.
        installSplashScreen()
//            .setKeepOnScreenCondition { keep } // Menetapkan kondisi agar splash screen tetap ditampilkan selama variabel `keep` bernilai true.
//        Handler().postDelayed(
//            runner,
//            1280
//        ) // Mengatur penundaan untuk menghentikan splash screen setelah 1280 milidetik (1,28 detik).

        setContentView(R.layout.activity_main) // Mengatur tampilan konten utama dari activity.

        // Di sini, biasanya Anda akan melakukan inisialisasi objek seperti ViewPager2 dan sliderIndicator.
        // Namun, bagian ini masih perlu diimplementasikan tergantung pada logika aplikasi yang sebenarnya.


        initData()
        initView()
        setupViewPager()

//        val mAdapter = ArtikelAdapter()
//        mAdapter.setData(initData())

    }

    private fun setupViewPager() {
        // Mendapatkan referensi ke tampilan LinearLayout dengan ID ll_slider_dots
        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        // Membuat array untuk indikator slider, dengan panjang sesuai dengan jumlah artikel
        sliderIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            // Membuat ImageView untuk mewakili setiap indikator slider
            sliderIndicator[i] = ImageView(this)

            // Mengatur gambar indikator slider ke gambar titik non-aktif
            sliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )

            // Mengatur parameter untuk tata letak ImageView (indikator slider)
            val param = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // Menentukan margin ImageView
            param.setMargins(9, 0, 8, 0)
            // Menentukan posisi tampilan di tengah vertikal dalam LinearLayout
            param.gravity = Gravity.CENTER_VERTICAL

            // Menambahkan ImageView (indikator slider) ke tampilan LinearLayout (llSliderDots)
            llSliderDots.addView(sliderIndicator[i], param)
        }

        // Mengatur indikator slider pertama ke gambar titik aktif
        sliderIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,R.drawable.dot_active
            )
        )
    }


    private fun initView() {
        // Mendapatkan tampilan LinearLayout dengan ID yang sesuai.
        val llDzikirDoaSholat: LinearLayout = findViewById(R.id.ll_dzikir_doa_shalat)
        llDzikirDoaSholat.setOnClickListener {
            // Ketika LinearLayout diklik, Activity QauliyahSholatActivity akan dijalankan.
            startActivity(Intent(this, QauliyahSholatActivity::class.java))
        }

        val llDzikirSetiapSaatDzikir: LinearLayout = findViewById(R.id.ll_dzikir_setiap_saat)
        llDzikirSetiapSaatDzikir.setOnClickListener {
            // Ketika LinearLayout diklik, Activity SetiapSaatDzikirActivity akan dijalankan.
            startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
        }

        val llDzikirDoaHarian: LinearLayout = findViewById(R.id.ll_dzikir_doa_harian)
        llDzikirDoaHarian.setOnClickListener {
            // Ketika LinearLayout diklik, Activity HarianDzikirDoaActivity akan dijalankan.
            startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
        }

        val llDzikirPagiPetangDzikir: LinearLayout = findViewById(R.id.ll_dzikir_pagi_petang)
        llDzikirPagiPetangDzikir.setOnClickListener {
            // Ketika LinearLayout diklik, Activity PagiPetangDzikirActivity akan dijalankan.
            startActivity(Intent(this, PagiPetangDzikirActivity::class.java))
        }

        vpArtikel = findViewById(R.id.vp_articel)
        val mAdapter = ArtikelAdapter()
        mAdapter.setData(listArtikel)
        vpArtikel.adapter = mAdapter

        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        mAdapter.setOnItemClickCallback(object : OnItemCallback{
            override fun onItemClicked(item:Artikel) {
                val intent = Intent(this@MainActivity, DetailArtikelActivity::class.java)
                intent.putExtra("data",item)
                startActivity(intent)
            }

        })


    }

    private fun initData(): List<Artikel> {
        // Mengambil array judul, konten, dan ID gambar dari sumber daya.
        val titleArticle = resources.getStringArray(R.array.arr_title_artikel)
        val contentArticle = resources.getStringArray(R.array.arr_desc_artikel)
        val imageArticle = resources.obtainTypedArray(R.array.arr_img_artikel)

        // Membuat listData untuk menyimpan objek Artikel.
        val listData = mutableListOf<Artikel>()

        // Loop melalui array judul dan konten.
        for (i in titleArticle.indices) {
            // Membuat objek Artikel dengan mengambil ID gambar, judul, dan konten yang sesuai.
            val data = Artikel(
                imageArticle.getResourceId(i, 0), // Mengambil ID gambar
                titleArticle[i],
                contentArticle[i]
            )
            // Menambahkan objek Artikel ke dalam listArtikel.
            listArtikel.add(data)
        }

        // Mendaur ulang array typed untuk menghindari memory leak.
        imageArticle.recycle()

        // Mengembalikan listData yang berisi objek-objek Artikel.
        return listData
    }



}
