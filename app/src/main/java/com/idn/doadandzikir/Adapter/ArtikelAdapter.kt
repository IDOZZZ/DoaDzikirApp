package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.Artikel
import com.idn.doadandzikir.databinding.ItemArtikelBinding
import com.idn.doadandzikir.utills.OnItemCallback

// Adapter untuk menampilkan daftar artikel dalam RecyclerView
class ArtikelAdapter: RecyclerView.Adapter<ArtikelAdapter.ArticleViewHolder>() {

    private val listArtikel = ArrayList<Artikel>()
    private var onItemCallback: OnItemCallback? = null

    fun setData(list : List<Artikel>){
    listArtikel.clear()
    listArtikel.addAll(list)
    }

    fun setOnItemClickCallback(onItemCallback: OnItemCallback) {
        this.onItemCallback = onItemCallback
    }

    // ViewHolder untuk setiap item dalam RecyclerView
    inner class ArticleViewHolder(val view: ItemArtikelBinding) : RecyclerView.ViewHolder(view.root)

    // Membuat ViewHolder baru sesuai dengan tampilan item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ArticleViewHolder(
        ItemArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    // Mendapatkan jumlah total item dalam daftar
    override fun getItemCount() = listArtikel.size


    // Mengikat data dari daftar ke tampilan item dalam RecyclerView
    override fun onBindViewHolder(holder: ArtikelAdapter.ArticleViewHolder, position: Int) {
        val data = listArtikel[position]
//        data image dari list artikel
        holder.view.imgArtikel.setImageResource(data.imageArtikel)
        holder.itemView.setOnClickListener {
            onItemCallback?.onItemClicked((data))
        }
    }
}
