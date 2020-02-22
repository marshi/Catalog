package marshi.android.catalog.app

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StyleRes
import com.airbnb.paris.extensions.style

class CatalogViewStyle<T : View>(
  private val clazz: Class<T>,
  @StyleRes private val styles: List<Int>,
  private val text: String?
) {
  fun createView(context: Context): List<View> {
    return when (val instance = clazz.getConstructor(Context::class.java).newInstance(context)) {
      is TextView -> textStyles(context, *styles.toIntArray(), text = text)
      is ImageView -> imageStyles(context, *styles.toIntArray())
      is ViewGroup -> viewGroupStyles(*styles.toIntArray(), view = instance)
      else -> viewStyles(context, clazz, *styles.toIntArray())
    }
  }

  private fun <T : View> viewStyles(
    context: Context,
    clazz: Class<T>,
    @StyleRes vararg styles: Int
  ): List<T> {
    return styles.map { styleId ->
      clazz.getConstructor(Context::class.java).newInstance(context).apply {
        style(styleId)
      }
    }
  }

  private fun textStyles(
    context: Context,
    @StyleRes vararg styles: Int,
    text: String?
  ): List<TextView> {
    return styles.map { styleId ->
      TextView(context).apply {
        this.text = text
        style(styleId)
      }
    }
  }

  private fun imageStyles(
    context: Context,
    @StyleRes vararg styles: Int
  ): List<ImageView> {
    return styles.map { styleId ->
      ImageView(context).apply {
        style(styleId)
      }
    }
  }

  private fun viewGroupStyles(
    @StyleRes vararg styles: Int,
    view: ViewGroup
  ): List<ViewGroup> {
    return styles.map { styleId ->
      view.apply {
        style(styleId)
      }
    }
  }
}
