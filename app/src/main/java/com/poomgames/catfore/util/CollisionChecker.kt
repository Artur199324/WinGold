package com.poomgames.catfore.util

import android.graphics.Rect
import android.view.View

class CollisionChecker {
    companion object {
        fun View.checkViewCollision(view: View): Boolean {
            val ballRect = Rect()
            val goalRect = Rect()

            this.getHitRect(ballRect)
            view.getHitRect(goalRect)

            return Rect.intersects(ballRect, goalRect)
        }
    }
}