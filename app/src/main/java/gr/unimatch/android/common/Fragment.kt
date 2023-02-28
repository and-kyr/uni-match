package gr.unimatch.android.common

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment

fun Fragment.setContent(
    content: @Composable () -> Unit,
): View = ComposeView(requireContext()).apply {
    setContent(content)
}

fun Fragment.showToast(
    @StringRes resId: Int
) = context?.let { context ->
    Toast.makeText(context, resId, Toast.LENGTH_LONG).show()
}
