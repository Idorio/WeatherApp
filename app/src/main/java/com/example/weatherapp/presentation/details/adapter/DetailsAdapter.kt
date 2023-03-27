package com.example.weatherapp.presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeatherDetailItemBinding

class DetailsAdapter: RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    private val itemList = mutableListOf<String>()

    class DetailsViewHolder(
        private val viewBinding: WeatherDetailItemBinding
    ): RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(model: String){
            viewBinding.content.text = model
        }
    }

    fun setItems(items: List<String>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val viewBinding = WeatherDetailItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DetailsViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}