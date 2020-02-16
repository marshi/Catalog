package marshi.android.catalog.app

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StyleRes
import com.airbnb.paris.extensions.style

class Catalog(val views: List<View>)

class CatalogBuilder {

  private val views = mutableListOf<View>()

  fun <T : View> styles(
    context: Context,
    clazz: Class<T>,
    @StyleRes vararg styles: Int,
    text: String? = null
  ) {
    val viewList =
      when (val instance = clazz.getConstructor(Context::class.java).newInstance(context)) {
      is TextView -> textStyles(context, *styles, text = text)
      is ImageView -> imageStyles(context, *styles)
      is ViewGroup -> viewGroupStyles(context, *styles, view = instance)
      else -> viewStyles(context, clazz, *styles)
    }
    views.addAll(viewList)
  }

  fun build(): Catalog {
    return Catalog(views)
  }

  private fun <T : View> viewStyles(
    context: Context,
    clazz: Class<T>, @StyleRes vararg styles: Int
  ): List<T> {
    return styles.map { styleId ->
      clazz.getConstructor(Context::class.java).newInstance(context).apply {
        style(styleId)
      }
    }
  }

  private fun textStyles(
    context: Context, @StyleRes vararg styles: Int,
    text: String?
  ): List<TextView> {
    return styles.map { styleId ->
      TextView(context).apply {
        this.text = text
        style(styleId)
      }
    }
  }

  private fun imageStyles(context: Context, @StyleRes vararg styles: Int): List<ImageView> {
    return styles.map { styleId ->
      ImageView(context).apply {
        style(styleId)
      }
    }
  }

  private fun viewGroupStyles(
    context: Context, @StyleRes vararg styles: Int,
    view: ViewGroup
  ): List<ViewGroup> {
    return styles.map { styleId ->
      view.apply {
        style(styleId)
      }
    }
  }
}
