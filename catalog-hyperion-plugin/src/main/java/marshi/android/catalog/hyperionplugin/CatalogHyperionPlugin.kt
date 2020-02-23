package marshi.android.catalog.hyperionplugin

import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule
import marshi.android.catalog.app.Catalog

@AutoService(Plugin::class)
class CatalogHyperionPlugin : Plugin() {

  companion object {
    var catalog: Catalog? = null
      private set

    fun register(catalog: Catalog) {
      this.catalog = catalog
    }
  }

  override fun createPluginModule(): PluginModule? {
    return CatalogPluginModule()
  }
}
