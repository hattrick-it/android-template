package com.hattrick.myapplication.presentation.base

import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseActivity<T : BaseViewModel, B : ViewBinding>(clazz: KClass<T>) :
    FragmentActivity() {

    //region Properties
    protected val viewModel = getViewModel(clazz = clazz)
    protected lateinit var binding: B
    //endregion

    //region Lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        setupUI()
        setupInputsViewModel()
        setupOutputsViewModel()
        keepScreenOn()
    }
    //endregion

    //region utils
    open fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 40)
        toast.show()
    }
    //endregion

    //region Overrides
    abstract fun getViewBinding(): B

    open fun setupUI() {}

    open fun setupInputsViewModel() {}

    open fun setupOutputsViewModel() {}
    //endregion

    //region Private methods
    private fun showLoadingDialog() {
        //TODO: show loading indicator
    }

    private fun hideLoadingDialog() {
        //TODO: hide loading indicator
    }

    private fun keepScreenOn() {
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
    //endregion

}
