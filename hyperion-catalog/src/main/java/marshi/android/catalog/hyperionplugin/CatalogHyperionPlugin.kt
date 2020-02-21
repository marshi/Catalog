package marshi.android.catalog.hyperionplugin

import com.google.auto.service.AutoService
import com.willowtreeapps.hyperion.plugin.v1.Plugin
import com.willowtreeapps.hyperion.plugin.v1.PluginModule

@AutoService(Plugin::class)
class CatalogHyperionPlugin : Plugin() {

  override fun createPluginModule(): PluginModule? {
    return CatalogPluginModule()
  }
}
