package com.hattrick.myapplication.presentation.fragment

import com.hattrick.myapplication.databinding.FragmentSampleBinding
import com.hattrick.myapplication.presentation.base.BaseFragment
import com.hattrick.myapplication.presentation.viewmodel.SampleViewModel

class SampleFragment : BaseFragment<SampleViewModel, FragmentSampleBinding>(SampleViewModel::class) {

    override fun getViewBinding() = FragmentSampleBinding.inflate(layoutInflater)

}