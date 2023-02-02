package com.poomgames.catfore.presentation.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import com.poomgames.catfore.databinding.FragmentGameBinding
import com.poomgames.catfore.presentation.activities.MainActivity
import com.poomgames.catfore.util.CollisionChecker.Companion.checkViewCollision
import java.util.*
import kotlin.random.Random

class GameFragment : Fragment() {

    private var binding: FragmentGameBinding? = null
    private var timer: Timer = Timer()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.gameConstraintLayout?.background = ContextCompat.getDrawable(
            requireContext(),
            (activity as MainActivity).gameViewModel.getBackground()
        )
        startBlockingGoalAnimation()
        updateScore()
        createNewBall()
    }

    private fun startBlockingGoalAnimation() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).postDelayed({
                    binding!!.barrierView.animate()
                        .x(0 - binding!!.barrierView.width.toFloat())
                        .setDuration(2000)
                        .start()
                }, 0)
                Handler(Looper.getMainLooper()).postDelayed({
                    binding!!.barrierView.animate()
                        .x(binding!!.gameConstraintLayout.width.toFloat())
                        .setDuration(2000)
                        .start()
                }, 2000)
            }

        }, 500, 4000)
    }

    private fun updateScore() {
        (activity as MainActivity).gameViewModel.getScore().observe(viewLifecycleOwner) {
            binding?.scoreText?.text = "Score: $it"
        }
    }

    private fun createNewBall() {
        val ball = ImageView(requireContext())
        ball.setImageResource((activity as MainActivity).gameViewModel.getBall())
        binding?.gameConstraintLayout?.addView(ball)
        ball.updateLayoutParams<ConstraintLayout.LayoutParams> {
            width = 120
            height = 120
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
            rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
            bottomMargin = 100
        }

        animationWithClick(ball)
    }

    private fun animationWithClick(ball: View) {
        ball.setOnClickListener {
            val randX = Random.nextInt(
                (ball.x - ball.width * 2).toInt(),
                (ball.x + ball.width * 2).toInt()
            ).toFloat()

            ball.animate()
                .x(randX)
                .y(0f)
                .rotation(Random.nextInt(500, 1000).toFloat())
                .setDuration(1000)
                .setUpdateListener {
                    if (ball.checkViewCollision(binding!!.goalView)) {
                        (activity as MainActivity).gameViewModel.setScore(5)
                        updateScore()
                        binding?.gameConstraintLayout?.removeView(ball)
                        createNewBall()
                    }

                    if (ball.checkViewCollision(binding!!.barrierView)) {
                        (activity as MainActivity).gameViewModel.setScore(-10)
                        updateScore()
                        binding?.gameConstraintLayout?.removeView(ball)
                        createNewBall()
                    }
                }
                .start()
        }
    }
}