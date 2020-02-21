package marshi.android.catalog

import android.app.Application
import marshi.android.catalog.hyperionplugin.CatalogHyperionPlugin

class DebugApp : Application() {

  override fun onCreate() {
    super.onCreate()
    val catalogFactory = CatalogFactory(this)
    val catalog = catalogFactory.create()
    CatalogHyperionPlugin.register(catalog)
  }
}
