package marshi.android.catalog.app

import android.view.View
import androidx.annotation.StyleRes

class CatalogBuilder {

  private val viewStyles = mutableListOf<CatalogViewStyle<out View>>()

  fun <T : View> style(
    title: String,
    clazz: Class<T>,
    @StyleRes vararg styles: Int,
    text: String? = null
  ) {
    viewStyles.add(CatalogViewStyle(title, clazz, styles.asList(), text))
  }

  fun build(): Catalog {
    return Catalog(viewStyles)
  }
}
