package marshi.android.catalog

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import marshi.android.catalog.annotation.UiComponent
import marshi.android.catalog.databinding.CustomViewBinding
import java.io.Serializable

@UiComponent
class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : Serializable, AppCompatTextView(
    context, attrs, defStyle
) {
    val binding = CustomViewBinding.inflate(LayoutInflater.from(context), null, true)

    init {
        if (!isInEditMode) {
        }
    }
}

