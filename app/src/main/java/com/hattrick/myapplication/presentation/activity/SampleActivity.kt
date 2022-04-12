package com.hattrick.myapplication.presentation.activity

import com.hattrick.myapplication.databinding.ActivitySampleBinding
import com.hattrick.myapplication.presentation.base.BaseActivity
import com.hattrick.myapplication.presentation.viewmodel.SampleViewModel

class SampleActivity :
    BaseActivity<SampleViewModel, ActivitySampleBinding>(SampleViewModel::class) {

    override fun getViewBinding(): ActivitySampleBinding =
        ActivitySampleBinding.inflate(layoutInflater)

}