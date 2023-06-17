package com.baladroid.baseapp.utils.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide

/*
View
 */
fun View.hideKeyBoard() {
    val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}



fun View.visibleOrGone(visible: Boolean) {
    if (visible) visible() else gone()
}

fun View.visibleOrInvisible(visible: Boolean) {
    if (visible) visible() else invisible()
}

fun View.gone() {
    visibility = View.GONE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.enabled(enabled: Boolean) {
    if (enabled) enabled() else disabled()
}

fun View.enabled() {
    isEnabled = true
}

fun View.disabled() {
    isEnabled = false
}

@BindingAdapter("imageUrl")
fun loadImage(view: View,
              imageUrl: String?) {
    val image: ImageView = view as ImageView

    val circularProgressDrawable = CircularProgressDrawable(view.context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.start()

    Glide.with(image.context)
        .load(imageUrl)
        //.placeholder(circularProgressDrawable)
        .into(image)
}


