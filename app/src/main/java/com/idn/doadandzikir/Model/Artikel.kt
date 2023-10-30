package com.idn.doadandzikir.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//untuk menentukan data apa yang di butuhkan
@Parcelize
data class Artikel(
    val imageArtikel: Int,
    val titleArtikel: String,
    val descArtikel: String
): Parcelable