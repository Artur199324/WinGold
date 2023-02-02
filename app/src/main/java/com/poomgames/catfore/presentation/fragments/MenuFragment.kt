package com.poomgames.catfore.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.poomgames.catfore.R
import com.poomgames.catfore.databinding.FragmentMenuBinding
import com.poomgames.catfore.presentation.activities.MainActivity
import java.util.*
import kotlin.random.Random

class MenuFragment : Fragment() {

    private var binding: FragmentMenuBinding? = null
    private lateinit var timer: Timer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        overrideBackButton()
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateScore()
        binding?.playButton?.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }
        binding?.shopButton?.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_shopFragment)
        }
        (activity as MainActivity).gameViewModel.insertShopItems()
    }

    override fun onStart() {
        super.onStart()
        timer = Timer()
        val resource = (activity as MainActivity).gameViewModel.getBall()
        binding!!.menuBall.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), resource)
        )
        animateBall()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    private fun updateScore() {
        (activity as MainActivity).gameViewModel.getScore().observe(viewLifecycleOwner) {
            binding?.scoreMenuText?.text = "Score: $it"
        }
    }

    private fun animateBall() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {
                    binding!!.menuBall.animate()
                        .x(Random.nextInt(100, resources.displayMetrics.widthPixels) - 100f)
                        .y(Random.nextInt(100, resources.displayMetrics.heightPixels) - 100f)
                        .rotation(Random.nextInt(500, 700).toFloat())
                        .setDuration(2000)
                        .start()
                }
            }
        }, 0, 2000)
    }

    private fun overrideBackButton() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }
}