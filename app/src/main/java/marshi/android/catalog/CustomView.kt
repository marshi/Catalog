package marshi.android.catalog

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import marshi.android.catalog.databinding.CustomViewBinding

class CustomView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : ConstraintLayout(
  context, attrs, defStyle
) {
  private val binding = CustomViewBinding.inflate(LayoutInflater.from(context), this, true)

  init {
    val a = context.obtainStyledAttributes(
      attrs,
      intArrayOf(),
      defStyle,
      0
    )
    a.recycle()
  }
}
