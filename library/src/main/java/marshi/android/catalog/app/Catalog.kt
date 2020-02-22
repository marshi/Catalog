package marshi.android.catalog.app

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StyleRes
import com.airbnb.paris.extensions.style

class Catalog(val views: List<CatalogViewStyle<out View>>) {

  fun create(context: Context, vs: CatalogViewStyle<out View>): List<View> {
    return when (val instance = vs.clazz.getConstructor(Context::class.java).newInstance(context)) {
      is TextView -> textStyles(context, *vs.styles.toIntArray(), text = vs.text)
      is ImageView -> imageStyles(context, *vs.styles.toIntArray())
      is ViewGroup -> viewGroupStyles(*vs.styles.toIntArray(), view = instance)
      else -> viewStyles(context, vs.clazz, *vs.styles.toIntArray())
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

class CatalogViewStyle<T : View>(
  val clazz: Class<T>,
  @StyleRes val styles: List<Int>,
  val text: String?
)

class CatalogBuilder {

  private val views = mutableListOf<View>()
  private val viewStyles = mutableListOf<CatalogViewStyle<out View>>()

  fun <T : View> style(
    clazz: Class<T>,
    @StyleRes vararg styles: Int,
    text: String? = null
  ) {
    viewStyles.add(CatalogViewStyle(clazz, styles.asList(), text))
  }

  fun <T : View> styles(
    context: Context,
    clazz: Class<T>,
    @StyleRes vararg styles: Int,
    text: String? = null
  ) {
//    val viewList =
//      when (val instance = clazz.getConstructor(Context::class.java).newInstance(context)) {
//        is TextView -> textStyles(context, *styles, text = text)
//        is ImageView -> imageStyles(context, *styles)
//        is ViewGroup -> viewGroupStyles(*styles, view = instance)
//        else -> viewStyles(context, clazz, *styles)
//      }
//    views.addAll(viewList)
  }


  fun build(): Catalog {
    return Catalog(viewStyles)
  }

}
