package com.idn.doadandzikir.utills

import com.idn.doadandzikir.Model.Artikel

interface OnItemCallback {
//    manggil item artikel di paracelize
    fun onItemClicked(item: Artikel)
}