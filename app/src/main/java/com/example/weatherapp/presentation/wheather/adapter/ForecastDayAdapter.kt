package com.example.weatherapp.presentation.wheather.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ItemListBinding
import com.example.weatherapp.domain.model.ForecastDayEntity
import com.squareup.picasso.Picasso

class ForecastDayAdapter(
    private val itemClickListener: (ForecastDayEntity) -> Unit
) : RecyclerView.Adapter<ForecastDayAdapter.ForecastDayViewHolder>() {

    private val itemList = mutableListOf<ForecastDayEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastDayViewHolder {
        val viewBinding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ForecastDayViewHolder(viewBinding, clickListener = itemClickListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ForecastDayViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun setItems(items: List<ForecastDayEntity>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    class ForecastDayViewHolder(
        private val viewBinding: ItemListBinding,
        private val clickListener: (ForecastDayEntity) -> Unit
    ) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: ForecastDayEntity) {
            Picasso.get().load("https://${item.icon}")
                .into(viewBinding.im)
            viewBinding.tvDate.text = item.date
            viewBinding.tvCondition.text = item.text
            viewBinding.tvTemp.text = item.getTemperatureRange()
            viewBinding.rootContainer.setOnClickListener {
                clickListener.invoke(item)
            }
        }
    }
}