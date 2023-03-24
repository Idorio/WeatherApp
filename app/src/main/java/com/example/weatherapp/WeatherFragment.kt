package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


import com.example.weatherapp.databinding.FragmentWeatherBinding


import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!


    private val viewModel: WeatherViewModel by viewModels()



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




        viewModel.currentTemp.observe(viewLifecycleOwner) { WeatherModel ->
//            val maxMinTemp = "${WeatherModel.data?.current?.maxtemp_c}°C/${WeatherModel.data?.current?.mintemp_c}°C"
            binding.tvCurrentTemp.text = WeatherModel?.data?.current?.temp_c.toString() + "°C"
            binding.tvCity.text = WeatherModel?.data?.location?.name.toString()
            binding.tvCondition.text = WeatherModel?.data?.current?.condition?.text.toString()
            Picasso.get().load("https:" + WeatherModel?.data?.current?.condition?.icon)
                .into(binding.imWeather)
            binding.tvData.text = WeatherModel?.data?.current?.last_updated.toString()
            binding.tvMaxMinTemp.text =
                WeatherModel?.data?.forecast?.forecastday?.get(0)?.day?.mintemp_c?.toInt().toString() +
                        "°C/${WeatherModel?.data?.forecast?.forecastday?.get(0)?.day?.maxtemp_c?.toInt().toString()}°C"

        }

    }
}













