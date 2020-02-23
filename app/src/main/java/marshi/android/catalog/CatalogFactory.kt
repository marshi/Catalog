package marshi.android.catalog

import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import marshi.android.catalog.app.Catalog
import marshi.android.catalog.app.CatalogBuilder

class CatalogFactory() {
  fun create(): Catalog {
    val catalogBuilder = CatalogBuilder()
    catalogBuilder.style(
      "CustomView",
      CustomView::class.java,
      R.style.AppTheme_CustomView
    )
    catalogBuilder.style(
      "TextView",
      TextView::class.java,
      R.style.AppTheme_Text_Small,
      R.style.AppTheme_Text_Large,
      text = "text"
    )
    catalogBuilder.style(
      "Button",
      Button::class.java,
      R.style.AppTheme_Button_Large,
      R.style.AppTheme_Button_Middle,
      R.style.AppTheme_Button_Small,
      text = "button"
    )
    catalogBuilder.style(
      "ImageView",
      AppCompatImageView::class.java,
      R.style.AppTheme_Image_Small,
      R.style.AppTheme_Image_Large
    )
    return catalogBuilder.build()
  }
}
