package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class CatalogPluginModule : PluginModule() {
  override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
    val recyclerView = RecyclerView(parent.context)
//    return recyclerView
    return layoutInflater.inflate(R.layout.hyperion_menu_item_view, parent, false).apply {
      setOnClickListener {
        parent.context.startActivity(CatalogActivity.createIntent(parent.context))
      }
    }
//    return layoutInflater.inflate(R.layout.hyperion_menu_item_view, parent, false)
//    return HyperionMenuItemView(parent.context)
  }
}
