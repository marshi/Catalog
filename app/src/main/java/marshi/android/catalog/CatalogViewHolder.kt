package marshi.android.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import marshi.android.catalog.databinding.CatalogViewBinding

class CatalogViewAdapter(private val views: List<View>) :
  RecyclerView.Adapter<CatalogViewHolder>() {

  lateinit var binding: CatalogViewBinding

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
    binding = CatalogViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return CatalogViewHolder(binding.root)
  }

  override fun getItemCount(): Int = views.size

  override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
    binding.container.addView(views[position])
  }
}

class CatalogViewHolder(val v: View) : RecyclerView.ViewHolder(v)
