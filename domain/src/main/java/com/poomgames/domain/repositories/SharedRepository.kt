package com.poomgames.domain.repositories

interface SharedRepository {
    fun getScore(): Int
    fun setScore(score: Int)
    fun getBackground(defaultRes: Int): Int
    fun setBackground(resource: Int)
    fun getBall(defaultRes: Int): Int
    fun setBall(resource: Int)
    fun isFirstStart(): Boolean
}