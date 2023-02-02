package com.poomgames.catfore.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.poomgames.catfore.databinding.FragmentShopBinding
import com.poomgames.catfore.presentation.activities.MainActivity
import com.poomgames.catfore.presentation.adapters.ShopAdapter

class ShopFragment : Fragment() {

    private var binding: FragmentShopBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateScore()

        (activity as MainActivity).shopViewModel.getShopItems()
            .observe(viewLifecycleOwner) { shopItems ->
                val adapter = ShopAdapter(shopItems)
                adapter.callback = { item ->
                    val result = (activity as MainActivity).shopViewModel.buyShopItem(item)
                    Toast.makeText(requireContext(), result, Toast.LENGTH_SHORT).show()
                    updateScore()
                }
                binding?.shopItemsRecyclerView?.apply {
                    this.adapter = adapter
                    layoutManager = LinearLayoutManager(requireContext())
                }
            }
    }

    private fun updateScore() {
        (activity as MainActivity).shopViewModel.getScore().observe(viewLifecycleOwner) {
            binding?.shopScoreText?.text = "Score: $it"
        }
    }
}