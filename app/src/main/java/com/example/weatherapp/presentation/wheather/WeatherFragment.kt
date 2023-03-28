package com.example.weatherapp.presentation.wheather


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.domain.model.WeatherEntity
import com.example.weatherapp.presentation.MainViewModel
import com.example.weatherapp.presentation.routes.AppRoutes
import com.example.weatherapp.presentation.wheather.adapter.ForecastDayAdapter
import com.example.weatherapp.utils.Resources
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherFragment : Fragment() {

    companion object {
        private const val CITY_KEY = "city_key"
        fun newInstance(city: String): WeatherFragment {
            return WeatherFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_KEY, city)
                }
            }
        }
    }

    private val city: String by lazy {
        arguments?.getString(CITY_KEY, "") ?: ""
    }
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()
    private val router by activityViewModels<MainViewModel>()
    private val adapter by lazy {
        ForecastDayAdapter(
            itemClickListener = { forecastDay ->
                router.navigate(AppRoutes.Details(forecastDay))
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initViewModel()

    }

    private fun initViews() {
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.adapter = adapter
        binding.ibSearch.setOnClickListener {
            router.navigate(AppRoutes.Search)
        }
        binding.swipe.setOnRefreshListener {
            viewModel.getWeather(city)
        }
    }

    private fun initViewModel() {
        viewModel.getWeather(city)
        viewModel.currentTemp.observe(viewLifecycleOwner) { weatherModel ->
            binding.swipe.isRefreshing = false
            when (weatherModel) {
                is Resources.Error -> {
                    //TODO parse error case
                }
                is Resources.Loading -> {
                    //TODO parse loading case
                }
                is Resources.Success -> {
                    parserModel(weatherModel.data)
                }

            }
        }
    }

    private fun parserModel(model: WeatherEntity) {
        binding.tvCurrentTemp.text = model.temp_c.toString()
        binding.tvCity.text = model.city
        binding.tvCondition.text = model.text
        Picasso.get().load("https:" + model.icon).into(binding.imWeather)
        binding.tvData.text = model.lastUpdated
        binding.tvMaxMinTemp.text =
            model.getTemperatureRange(model.getCurrentDate())
        adapter.setItems(model.forecast)
    }
}













