package com.zahirar.tugasch4tpc3livedata

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.zahirar.tugasch4tpc3livedata.databinding.FragmentDetailProductBinding

class DetailProductFragment : Fragment() {
    lateinit var binding : FragmentDetailProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getSerializableProduct = arguments?.getSerializable("dataBerita") as DataProduct
        val image = getSerializableProduct.imgProduct
        val nama = getSerializableProduct.namaProduct
        val price = getSerializableProduct.hargaProduct
        val deskripsi = getSerializableProduct.deskripsiProduct

        binding.dataProduct = DataProduct(nama, price, deskripsi, image)

        binding.btnBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailProductFragment_to_productFragment)
        }
        binding.btnBuy.setOnClickListener {
            val msg = "Halo, saya tertarik dengan produk $nama dengan harga Rp.$price, apakah masih tersedia?"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+6283890177679 Number&text=$msg"))
            startActivity(intent)
        }
    }
}