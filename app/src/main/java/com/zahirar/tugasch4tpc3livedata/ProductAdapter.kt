package com.zahirar.tugasch4tpc3livedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zahirar.tugasch4tpc3livedata.databinding.ItemProductBinding

class ProductAdapter(var listDataProduct: ArrayList<DataProduct>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var onItemClick : ((DataProduct) -> Unit)? = null

    class ViewHolder (var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindproduct(itemProduct : DataProduct){
            binding.dataProduct = itemProduct
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindproduct(listDataProduct[position])
//        val img = listDataProduct[position].imgProduct
//        val name = listDataProduct[position].namaProduct
//        val price = listDataProduct[position].hargaProduct
//        val desc = listDataProduct[position].deskripsiProduct
        holder.binding.cvProduct.setOnClickListener {
            onItemClick?.invoke(listDataProduct[position])
        }
    }

    override fun getItemCount(): Int {
        return listDataProduct.size
    }

    fun setDataProduct(itemData : ArrayList<DataProduct>){
        this.listDataProduct = itemData
    }
}