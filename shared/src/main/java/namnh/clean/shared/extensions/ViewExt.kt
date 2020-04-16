package namnh.clean.shared.extensions

import android.os.SystemClock
import android.view.View

fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

fun View.isGone(): Boolean {
    return this.visibility == View.GONE
}

fun View.isInvisible(): Boolean {
    return this.visibility == View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.safeClick(blockInMillis: Long = 1000, onClick: (View) -> Unit) {
    var lastClickTime: Long = 0
    this.setOnClickListener {
        if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
        lastClickTime = SystemClock.elapsedRealtime()
        onClick(this)
    }
}

fun visibleViews(vararg views: View?) {
    views.map {
        if (it?.isVisible() == false) it.visible()
    }
}

fun invisibleViews(vararg views: View?) {
    views.map {
        if (it?.isInvisible() == false) it.invisible()
    }
}

fun goneViews(vararg views: View?) {
    views.map {
        if (it?.isGone() == false) it.gone()
    }
}
