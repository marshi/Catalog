package marshi.android.catalog

import android.content.Context
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import marshi.android.catalog.app.Catalog
import marshi.android.catalog.app.CatalogBuilder

class CatalogFactory(private val context: Context) {
  fun create(): Catalog {
    val catalogBuilder = CatalogBuilder()
    catalogBuilder.styles(
      context,
      CustomView::class.java,
      R.style.AppTheme_CustomView
    )
    catalogBuilder.styles(
      context,
      TextView::class.java,
      R.style.AppTheme_Text_Small,
      R.style.AppTheme_Text_Large,
      text = "text"
    )
    catalogBuilder.styles(
      context,
      Button::class.java,
      R.style.AppTheme_Button_Large,
      R.style.AppTheme_Button_Middle,
      R.style.AppTheme_Button_Small,
      text = "button"
    )
    catalogBuilder.styles(
      context,
      AppCompatImageView::class.java,
      R.style.AppTheme_Image_Small,
      R.style.AppTheme_Image_Large
    )
    return catalogBuilder.build()
  }
}