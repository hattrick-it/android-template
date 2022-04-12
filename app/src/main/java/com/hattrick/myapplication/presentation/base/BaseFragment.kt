package com.hattrick.myapplication.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hattrick.myapplication.R
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class BaseFragment<T : BaseViewModel, B : ViewBinding>(clazz: KClass<T>) : Fragment() {

    //region Properties
    protected val viewModel = getViewModel(clazz = clazz)
    protected val binding: B
        get() = _binding!!

    private var _binding: B? = null
    private var loadingDialog: Dialog? = null
    //endregion

    //region Lifecycle
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupInputsViewModel()
        setupInputsViewModelBase()
        setupOutputsViewModel()
        setupOutputsViewModelBase()
    }

    override fun onPause() {
        super.onPause()

        hideLoadingDialog()
    }
    //endregion


    //region Overrides
    abstract fun getViewBinding(): B

    open fun setupInputsViewModel() {}

    open fun setupOutputsViewModel() {}

    open fun setupUI() {}

    open fun showToast(message: String) {
        val toast = Toast.makeText(this.context, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 40)
        toast.show()
    }
    //endregion

    //region Private methods
    private fun setupInputsViewModelBase() {}

    private fun setupOutputsViewModelBase() {
        viewModel.isLoading.observe(this.viewLifecycleOwner) {
            if (it)
                showLoadingDialog()
            else
                hideLoadingDialog()
        }
    }

    open fun showLoadingDialog() {
        loadingDialog = Dialog(this.requireContext())
        loadingDialog!!.setContentView(R.layout.dialog_loading)
        loadingDialog!!.show()
    }

    open fun hideLoadingDialog() {
        if (loadingDialog != null && loadingDialog!!.isShowing) {
            loadingDialog!!.dismiss()
        }
    }
    //endregion

}