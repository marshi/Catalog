package marshi.android.catalog.hyperionplugin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.catalog_component_list_view.view.*
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

  override fun getItemCount(): Int = catalog.viewStyles.size

  override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
    val listView = holder.listView
    val catalogViewStyle = catalog.viewStyles[position]
    catalogViewStyle.createView(listView.context).forEach { view ->
      listView.title.text = catalogViewStyle.title
      val itemViewBinding =
        CatalogComponentItemViewBinding.inflate(
          LayoutInflater.from(listView.context),
          listView,
          true
        )
      itemViewBinding.container.addView(view)
    }
  }
}

class CatalogViewHolder(val listView: ViewGroup) :
  RecyclerView.ViewHolder(listView)
