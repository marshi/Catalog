package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.catalog.app.Catalog
import marshi.android.catalog.hyperionplugin.databinding.CatalogComponentViewBinding

internal class CatalogViewAdapter(private val catalog: Catalog) :
  RecyclerView.Adapter<CatalogViewHolder>() {

  lateinit var binding: CatalogComponentViewBinding

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
    binding =
      CatalogComponentViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return CatalogViewHolder(binding.container)
  }

  override fun getItemCount(): Int = catalog.views.size

  override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
    val viewStyle = catalog.views[position]
    catalog.create(holder.v.context, viewStyle).forEach { view ->
      binding.container.addView(view)
    }
  }
}

class CatalogViewHolder(val v: ViewGroup) : RecyclerView.ViewHolder(v)
