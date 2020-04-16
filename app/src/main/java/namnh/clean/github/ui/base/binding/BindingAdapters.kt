package namnh.clean.github.ui.base.binding

import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import android.text.TextUtils
import android.text.style.AbsoluteSizeSpan
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.core.text.bold
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import namnh.clean.shared.extensions.gone
import namnh.clean.shared.extensions.visible
import java.util.*

/**
 * All Data Binding adapters specific to the app should be here.
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("goneIfMatch")
    fun goneIfMatch(view: View, condition: Boolean) {
        if (condition) view.gone() else view.visible()
    }

    @JvmStatic
    @BindingAdapter("visibleIfMatch")
    fun visibleIfMatch(view: View, condition: Boolean?) {
        if (condition == true) view.visible() else view.gone()
    }

    @JvmStatic
    @BindingAdapter("background")
    fun backgroundResource(view: View, @DrawableRes resId: Int) {
        if (view is ImageView) {
            view.setImageResource(resId)
        } else {
            view.setBackgroundResource(resId)
        }
    }
}
