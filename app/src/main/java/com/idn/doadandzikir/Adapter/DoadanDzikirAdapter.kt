package com.idn.doadandzikir.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.idn.doadandzikir.Model.DoadanDzikirItem
import com.idn.doadandzikir.R

class DoadanDzikirAdapter : RecyclerView.Adapter<DoadanDzikirAdapter.DzikirViewHolder>(){

//    ngambil di DoadanDzikirItem
    private val listData = ArrayList<DoadanDzikirItem>()

//    mengesed dengan funtion
    fun setData(list : List<DoadanDzikirItem>){
        listData.clear()
        listData.addAll(list)
    }
//   yang di atas untuk mengisi inner di bawah ini
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle = view.findViewById<TextView>(R.id.tv_desc)
        val textIsi = view.findViewById<TextView>(R.id.tv_lafaz)
        val textTerjemah = view.findViewById<TextView>(R.id.tv_terjemah)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DzikirViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_dzikir_doa,parent,false)
    )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        holder.apply {
            itemTitle.text = listData[position].title
            textIsi.text = listData[position].desc
            textTerjemah.text = listData[position].translate
    }




    }

}