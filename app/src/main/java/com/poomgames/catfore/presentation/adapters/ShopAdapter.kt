package com.poomgames.catfore.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.poomgames.catfore.databinding.ShopItemBinding
import com.poomgames.domain.entities.ShopItem

class ShopAdapter(
    private val shopList: List<ShopItem>
) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    var callback: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = ShopItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount() = shopList.size

    inner class ShopViewHolder(
        private val binding: ShopItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(shopItem: ShopItem) {
            if (shopItem.bought) binding.buyButton.text = "Change"
            binding.itemImage.setImageBitmap(
                ContextCompat.getDrawable(itemView.context, shopItem.imageRec)
                    ?.toBitmap(100, 100)
            )
            binding.buyButton.setOnClickListener { callback?.invoke(shopList[adapterPosition]) }
            binding.nameText.text = shopItem.name
            binding.subtitleText.text = shopItem.price.toString()
        }
    }
}