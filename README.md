# Catalog

Catalog support show UI component list.

# Get started

```groovy
dependencies {
  implementation "marshi.android:catalog:0.0.1"
  debugImplementation "marshi.android:catalog-hyperion-plugin:0.0.1" // if you use hyperion.
}
```

Define style, then add them to CatalogBuilder.

CatalogBuilder generate Catalog object which has views applied styles.

```kotlin
class CatalogFactory() {
  fun create(): Catalog {
    val catalogBuilder = CatalogBuilder()
    catalogBuilder.style(
      "CustomView", 
      CustomView::class.java,
      R.style.AppTheme_CustomView
    )
    catalogBuilder.style(
      "TextView",
      TextView::class.java,
      R.style.AppTheme_Text_Small,
      R.style.AppTheme_Text_Large,
      text = "text"
    )
    return catalogBuilder.build()
  }
}
```

If you use hyperion, can use CatalogHyperionPlugin.

"Catalog: UI Component" menu is added to hyperion menu.

```
class DebugApp : Application() {

  override fun onCreate() {
    super.onCreate()
    val catalogFactory = CatalogFactory()
    val catalog = catalogFactory.create()
    CatalogHyperionPlugin.register(catalog)
  }
}
```
