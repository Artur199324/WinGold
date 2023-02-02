package com.poomgames.domain.entities

data class ShopItem(
    val imageRec: Int,
    val name: String,
    val price: Int,
    var bought: Boolean,
    var isBall: Boolean,
)
