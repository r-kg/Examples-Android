package com.rkg.examples_android.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.rkg.examples_android.presentation.ui.main.MainActivity

inline fun <reified T : Activity> Context.startActivity(initializer: Intent.() -> Unit = {}) {
    val intent = Intent(this, T::class.java).apply {
        initializer()
    }

    startActivity(intent)
}

fun Activity.startMainOnNewTask() {
    startActivity<MainActivity> {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
    }
    overridePendingTransition(0, 0)
}