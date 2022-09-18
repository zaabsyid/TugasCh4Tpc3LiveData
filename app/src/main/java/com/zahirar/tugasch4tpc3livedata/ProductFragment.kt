package com.zahirar.tugasch4tpc3livedata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.zahirar.tugasch4tpc3livedata.databinding.FragmentProductBinding

class ProductFragment : Fragment() {

    lateinit var binding : FragmentProductBinding
    lateinit var vmProduct : ViewModelProduct
    lateinit var adapterProduct : ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vmProduct = ViewModelProvider(this).get(ViewModelProduct::class.java)
        adapterProduct = ProductAdapter(ArrayList())

        vmProduct.getProduct()
        vmProduct.product.observe(viewLifecycleOwner, Observer {
            adapterProduct.setDataProduct(it as ArrayList<DataProduct>)
        })

        adapterProduct.onItemClick = {
            val sendData = Bundle()
            sendData.putSerializable("dataBerita", it)

            Navigation.findNavController(view).navigate(R.id.action_productFragment_to_detailProductFragment, sendData)
        }

        binding.rvListProduct.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvListProduct.adapter = adapterProduct
    }
}