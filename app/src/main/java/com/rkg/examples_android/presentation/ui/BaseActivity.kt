package com.rkg.examples_android.presentation.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelLazy
import java.lang.reflect.ParameterizedType
import com.rkg.examples_android.BR

@Suppress("UNCHECKED_CAST")
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(@LayoutRes val layoutResId: Int) :
    AppCompatActivity() {

    protected lateinit var binding: B

    private val viewModelClass = ((javaClass.genericSuperclass as ParameterizedType?)
        ?.actualTypeArguments
        ?.get(1) as Class<VM>).kotlin

    protected open val viewModel by ViewModelLazy(
        viewModelClass,
        { viewModelStore },
        { defaultViewModelProviderFactory }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<B>(
            this,
            layoutResId
        ).apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.vm, viewModel)
        }.also {
            binding = it
        }
    }
}