package com.poomgames.catfore.presentation.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.poomgames.catfore.R
import com.poomgames.catfore.databinding.FragmentLoadingBinding
import com.poomgames.catfore.load.LoadCupInerf
import com.poomgames.catfore.presentation.LoadCup
import com.poomgames.catfore.presentation.activities.MainActivity
import com.poomgames.catfore.presentation.activities.WorldCupActivity
import com.poomgames.catfore.presentation.see.SeeeWe.ddd
import java.util.*

class LoadingFragment : Fragment(), LoadCupInerf {

    private var binding: FragmentLoadingBinding? = null
    private var timer = Timer()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoadingBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).loadingViewModel.getRandomFact().observe(viewLifecycleOwner) {
            binding?.textView?.text = it.hintText
        }
        startWithDelay()
    }

    private fun startWithDelay() {
        var i = 0f
        if (!ddd) {
            findNavController().navigate(R.id.action_loadingFragment_to_menuFragment)
        } else {
        LoadCup.laad(this)}
        timer.schedule(object : TimerTask() {
            override fun run() {
                activity?.runOnUiThread {
                    binding?.percentageProgressBar?.setProgress(++i)
                    if (i == 100f) {
                        timer.cancel()

                    }
                }
            }
        }, 0, 300)
    }

    override fun loadCup(s: String?, ss: String) {

            if (s.equals("")) {
                findNavController().navigate(R.id.action_loadingFragment_to_menuFragment)
            } else {
                val intent = Intent(context, WorldCupActivity::class.java)
                intent.putExtra(requireActivity().packageName + "llll", s)
                intent.putExtra(requireActivity().packageName + "gggg", ss)
                requireActivity().startActivity(intent)
                requireActivity().finish()
            }

    }
}