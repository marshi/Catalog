package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class CatalogPluginModule : PluginModule() {
  override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
    val recyclerView = RecyclerView(parent.context)
//    return recyclerView
    return TextView(parent.context).apply {
      text = "aiueo"
      setOnClickListener {
        parent.context.startActivity(CatalogActivity.createIntent(parent.context))
      }
    }
//    return layoutInflater.inflate(R.layout.sample_hyperion_menu_item_view, parent, false)
//    return HyperionMenuItemView(parent.context)
  }
}
