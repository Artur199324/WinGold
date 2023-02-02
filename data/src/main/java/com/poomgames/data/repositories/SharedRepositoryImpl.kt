package com.poomgames.data.repositories

import android.content.SharedPreferences
import com.poomgames.domain.Utils
import com.poomgames.domain.repositories.SharedRepository
import javax.inject.Inject

class SharedRepositoryImpl @Inject constructor(
    private val prefs: SharedPreferences
) : SharedRepository {

    override fun getScore() = prefs.getInt(Utils.SCORE_TAG, 0)

    override fun setScore(score: Int) {
        var newScore = score + getScore()
        if (newScore < 0) newScore = 0
        prefs.edit()
            .putInt(Utils.SCORE_TAG, newScore)
            .apply()
    }

    override fun getBackground(defaultRes: Int) = prefs.getInt(Utils.BACKGROUND_TAG, defaultRes)

    override fun setBackground(resource: Int) {
        prefs.edit()
            .putInt(Utils.BACKGROUND_TAG, resource)
            .apply()
    }

    override fun getBall(defaultRes: Int) = prefs.getInt(Utils.BALL_TAG, defaultRes)

    override fun setBall(resource: Int) {
        prefs.edit()
            .putInt(Utils.BALL_TAG, resource)
            .apply()
    }

    override fun isFirstStart(): Boolean {
        if (prefs.getBoolean(Utils.FIRST_START, true)) {
            prefs.edit()
                .putBoolean(Utils.FIRST_START, false)
                .apply()
            return true
        }
        return false
    }
}