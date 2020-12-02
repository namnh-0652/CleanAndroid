package namnh.clean.sample.helper.error

import android.app.Activity
import androidx.fragment.app.Fragment

interface ErrorHandler {
    fun proceed(
        fragment: Fragment?,
        error: Throwable?
    )

    fun proceed(
        activity: Activity?,
        error: Throwable?
    )
}
