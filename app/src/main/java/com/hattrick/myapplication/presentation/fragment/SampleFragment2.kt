package com.hattrick.myapplication.presentation.fragment

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hattrick.myapplication.databinding.FragmentSample2Binding
import com.hattrick.myapplication.presentation.base.BaseFragment
import com.hattrick.myapplication.presentation.viewmodel.SampleViewModel

class SampleFragment2 : BaseFragment<SampleViewModel, FragmentSample2Binding>(SampleViewModel::class) {

    private val args: SampleFragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            findNavController().popBackStack()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getViewBinding(): FragmentSample2Binding = FragmentSample2Binding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.name
        binding.tvName.text = name

        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appCompatActivity.title = "Fragment 2"
    }

}


