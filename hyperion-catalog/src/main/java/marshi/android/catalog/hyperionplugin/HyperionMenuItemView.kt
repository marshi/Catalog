package marshi.android.catalog.hyperionplugin

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

class HyperionMenuItemView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
  init {
    LayoutInflater.from(context).inflate(R.layout.sample_hyperion_menu_item_view, this, true)
  }
}
