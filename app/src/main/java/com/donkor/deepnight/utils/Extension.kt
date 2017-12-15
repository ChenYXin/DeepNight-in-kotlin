package com.donkor.deepnight.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.widget.Toast

//import io.reactivex.Observable
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers

/**
 * Created by donkor on 2017/12/11.
 */
fun Context.showToast(message: String): Toast {
    var toast: Toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER, 0, 0)
    toast.show()
    return toast
}

inline fun <reified T : Activity?> Activity.switchActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

