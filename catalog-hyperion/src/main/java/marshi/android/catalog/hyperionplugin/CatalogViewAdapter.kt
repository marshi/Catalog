package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.catalog.app.Catalog
import marshi.android.catalog.hyperionplugin.databinding.CatalogComponentItemViewBinding
import marshi.android.catalog.hyperionplugin.databinding.CatalogComponentListViewBinding

internal class CatalogViewAdapter(private val catalog: Catalog) :
  RecyclerView.Adapter<CatalogViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
    val binding =
      CatalogComponentListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return CatalogViewHolder(binding.container)
  }

  override fun getItemCount(): Int = catalog.views.size

  override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
    catalog.views[position].create(holder.listView.context).forEach { view ->
      val itemViewBinding =
        CatalogComponentItemViewBinding.inflate(
          LayoutInflater.from(holder.listView.context),
          holder.listView,
          true
        )
      itemViewBinding.container.addView(view)
    }
  }
}

class CatalogViewHolder(val listView: ViewGroup) :
  RecyclerView.ViewHolder(listView)
