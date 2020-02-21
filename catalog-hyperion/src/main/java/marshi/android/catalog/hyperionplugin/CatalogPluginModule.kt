package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

class CatalogPluginModule() : PluginModule() {
  override fun createPluginView(layoutInflater: LayoutInflater, parent: ViewGroup): View? {
    return layoutInflater.inflate(R.layout.hyperion_menu_item_view, parent, false).apply {
      setOnClickListener {
        val intent = CatalogActivity.createIntent(parent.context)
        parent.context.startActivity(intent)
      }
    }
  }
}
