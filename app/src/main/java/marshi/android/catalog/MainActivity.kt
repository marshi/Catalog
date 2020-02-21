package marshi.android.catalog

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import marshi.android.catalog.app.CatalogBuilder
import marshi.android.catalog.databinding.ActivityMainBinding
import marshi.android.catalog.hyperionplugin.CatalogViewAdapter
import marshi.android.catalog.R as CatalogR

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding =
      DataBindingUtil.setContentView<ActivityMainBinding>(this, CatalogR.layout.activity_main)
    val catalogBuilder = CatalogBuilder()
    catalogBuilder.styles(
      this,
      CustomView::class.java,
      CatalogR.style.AppTheme_CustomView
    )
    catalogBuilder.styles(
      this,
      TextView::class.java,
      CatalogR.style.AppTheme_Text_Small,
      CatalogR.style.AppTheme_Text_Large,
      text = "text"
    )
    catalogBuilder.styles(
      this,
      Button::class.java,
      CatalogR.style.AppTheme_Button_Large,
      CatalogR.style.AppTheme_Button_Middle,
      CatalogR.style.AppTheme_Button_Small,
      text = "button"
    )
    catalogBuilder.styles(
      this,
      AppCompatImageView::class.java,
      CatalogR.style.AppTheme_Image_Small,
      CatalogR.style.AppTheme_Image_Large
    )
    binding.recyclerView.apply {
      adapter =
        CatalogViewAdapter(catalogBuilder.build())
    }
  }
}
