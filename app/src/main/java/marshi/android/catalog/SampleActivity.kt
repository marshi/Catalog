package marshi.android.catalog

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import marshi.android.catalog.app.CatalogBuilder
import marshi.android.catalog.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding =
      DataBindingUtil.setContentView<ActivitySampleBinding>(this, R.layout.activity_sample)
    val catalogBuilder = CatalogBuilder()
    catalogBuilder.styles(
      this,
      CustomView::class.java,
      R.style.AppTheme_CustomView
    )
    catalogBuilder.styles(
      this,
      TextView::class.java,
      R.style.AppTheme_Text_Small,
      R.style.AppTheme_Text_Large,
      text = "text"
    )
    catalogBuilder.styles(
      this,
      Button::class.java,
      R.style.AppTheme_Button_Large,
      R.style.AppTheme_Button_Middle,
      R.style.AppTheme_Button_Small,
      text = "button"
    )
    catalogBuilder.styles(
      this,
      AppCompatImageView::class.java,
      R.style.AppTheme_Image_Small,
      R.style.AppTheme_Image_Large
    )
    binding.recyclerView.apply {
      adapter =
        CatalogViewAdapter(catalogBuilder.build())
    }
  }
}
