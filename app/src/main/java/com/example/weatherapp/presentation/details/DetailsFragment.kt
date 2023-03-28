package com.example.weatherapp.presentation.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentDetailsBinding
import com.example.weatherapp.data.service.model.ForecastDay
import com.example.weatherapp.domain.model.ForecastDayEntity
import com.example.weatherapp.presentation.details.adapter.DetailsAdapter


class DetailsFragment : Fragment(R.layout.fragment_details) {

    companion object{
        private const val MODEL_KEY = "model_key"
        fun newInstance(model: ForecastDayEntity): DetailsFragment{
            val args = Bundle().apply {
                putSerializable(MODEL_KEY, model)
            }

            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private val model by lazy {
        arguments?.getSerializable(MODEL_KEY) as? ForecastDayEntity
    }
    private val adapter by lazy {
        DetailsAdapter()
    }
    private var viewBinding: FragmentDetailsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentDetailsBinding.bind(view)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initView() {
        viewBinding?.detailsRv?.layoutManager = LinearLayoutManager(requireContext())
        viewBinding?.detailsRv?.adapter = adapter
        renderView()
    }

    private fun renderView() {
        val result = mutableListOf<String>()
        result.add("Date: ${model?.date ?: ""}")
        result.add("Temperature range: ${model?.getTemperatureRange() ?: ""}")
        adapter.setItems(result)
    }
}