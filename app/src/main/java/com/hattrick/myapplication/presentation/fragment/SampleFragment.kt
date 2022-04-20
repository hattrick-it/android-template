package com.hattrick.myapplication.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.hattrick.myapplication.R
import com.hattrick.myapplication.databinding.FragmentSampleBinding
import com.hattrick.myapplication.presentation.base.BaseFragment
import com.hattrick.myapplication.presentation.viewmodel.SampleViewModel

class SampleFragment : BaseFragment<SampleViewModel, FragmentSampleBinding>(SampleViewModel::class) {

    override fun getViewBinding() = FragmentSampleBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navButton.setOnClickListener {
            val name = getString(R.string.app_name)
            val fromFragmentToFragment2 = SampleFragmentDirections.actionSampleFragmentToSampleFragment2(name)
            findNavController().navigate(fromFragmentToFragment2)
        }
    }

}