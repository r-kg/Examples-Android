package com.rkg.examples_android.presentation.ui.main

import android.os.Bundle
import com.rkg.examples_android.R
import com.rkg.examples_android.databinding.MainActivityBinding
import com.rkg.examples_android.presentation.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>(R.layout.main_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}