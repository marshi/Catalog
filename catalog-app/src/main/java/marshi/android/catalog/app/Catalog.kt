package marshi.android.catalog.app

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StyleRes
import com.airbnb.paris.extensions.style
import com.airbnb.paris.extensions.textViewStyle

class Catalog() {

  private val _views = mutableListOf<View>()
  val views: List<View> = _views

  fun <T : View> styles(
    context: Context,
    clazz: Class<T>,
    @StyleRes vararg styles: Int,
    text: String? = null
  ) {
    val instance = clazz.getConstructor(Context::class.java).newInstance(context)
    when (instance) {
      is TextView -> textStyles(context, *styles)
      is ImageView -> imageStyles(context, *styles)
      else -> viewStyles(context, clazz, *styles)
//      is ViewGroup -> viewGroupStyles(context, *styles)
    }
  }

  private fun <T : View> viewStyles(context: Context, clazz: Class<T>, @StyleRes vararg styles: Int) {
    val views = styles.map { styleId ->
      clazz.getConstructor(Context::class.java).newInstance(context).apply {
        style(styleId)
      }
    }
    _views.addAll(views)
  }

  private fun textStyles(context: Context, @StyleRes vararg styles: Int) {
    val textViews = styles.map { styleId ->
      TextView(context).apply {
        text = "text"
        style(styleId)
      }
    }
    _views.addAll(textViews)
  }

  private fun imageStyles(context: Context, @StyleRes vararg styles: Int) {
    val buttonViews = styles.map { styleId ->
      ImageView(context).apply {
        style(styleId)
      }
    }
    _views.addAll(buttonViews)
  }

//  fun viewGroupStyles(context: Context, @StyleRes vararg styles: Int) {
//    val buttonViews = styles.map { styleId ->
//      ViewGroup(context).apply {
//        style(styleId)
//      }
//    }
//    _views.addAll(buttonViews)
//  }
}
