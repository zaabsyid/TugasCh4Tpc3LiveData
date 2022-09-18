package com.zahirar.tugasch4tpc3livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProduct : ViewModel() {
    //deklarasi data
    val listDataProduct = arrayListOf(
        DataProduct("Panci", "25000",  "Panci ini lejat dan bergiji", R.drawable.panci),
        DataProduct("Baju", "60000",  "Baju ini lejat dan bergiji", R.drawable.kaos),
        DataProduct("Kuaci", "1000",  "Kuaci ini lejat dan bergiji", R.drawable.kuaci),
        DataProduct("Celana", "50000",  "Celana ini lejat dan bergiji", R.drawable.celana),
        DataProduct("Helm", "750000", "Helm ini lejat dan bergiji", R.drawable.kairoz),
    )
    // bikin live data
    val product : MutableLiveData<List<DataProduct>> = MutableLiveData()

    // set live data
    fun getProduct(){
        product.value = listDataProduct
    }

}