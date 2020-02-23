[![Build Status](https://app.bitrise.io/app/0be8213a8ab917b8/status.svg?token=Q1-kHm3Git_JZdZ5qh1eNQ&branch=master)](https://app.bitrise.io/app/0be8213a8ab917b8)
# Catalog

Catalog support to show UI component list.

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
    catalogBuilder.style(
      "Button",
      Button::class.java,
      R.style.AppTheme_Button_Large,
      R.style.AppTheme_Button_Middle,
      R.style.AppTheme_Button_Small,
      text = "button"
    )
    catalogBuilder.style(
      "ImageView",
      AppCompatImageView::class.java,
      R.style.AppTheme_Image_Small,
      R.style.AppTheme_Image_Large
    )
    return catalogBuilder.build()
  }
}
```

If you use hyperion, can use CatalogHyperionPlugin.

"Catalog: UI Component" menu is added to hyperion menu.

```kotlin
class DebugApp : Application() {

  override fun onCreate() {
    super.onCreate()
    val catalogFactory = CatalogFactory()
    val catalog = catalogFactory.create()
    CatalogHyperionPlugin.register(catalog)
  }
}
```

<img src="https://user-images.githubusercontent.com/1423942/75113179-c2193c80-568e-11ea-9f4d-c0f0902f6e36.gif" width="200" />
