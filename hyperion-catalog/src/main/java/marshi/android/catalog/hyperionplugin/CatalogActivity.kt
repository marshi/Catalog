package marshi.android.catalog.hyperionplugin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import marshi.android.catalog.hyperionplugin.databinding.ActivityComponentCatalogBinding

class CatalogActivity : AppCompatActivity() {

  companion object {
    fun createIntent(context: Context): Intent {
      return Intent(context, CatalogActivity::class.java)
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityComponentCatalogBinding>(
      this,
      R.layout.activity_component_catalog
    )
//    val catalogBuilder = CatalogBuilder()
//    binding.recyclerView.apply {
//      adapter = CatalogViewAdapter(catalogBuilder.build())
//    }
  }
}
