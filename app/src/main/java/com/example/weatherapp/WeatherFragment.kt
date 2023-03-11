package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.presentation.adapter.WeatherAdapter
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.model.WeatherModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private  var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()

    private lateinit var adapter : WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()

        viewModel.weatherResp.observe(viewLifecycleOwner) { weather ->
            binding.apply {
                tvCurrentTemp.text = weather.currentTemp
            }
        }
    }

    private fun initRcView() = with(binding){
        rcView.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rcView.adapter= adapter
        val list = mutableListOf<WeatherModel>(
            WeatherModel("","12:00","Sunny","","26","","",""),
            WeatherModel("","13:00","Sunny","","26","","",""),
            WeatherModel("","14:00","Sunny","","26","","",""),
            WeatherModel("","15:00","Sunny","","26","","",""),
            WeatherModel("","16:00","Sunny","","26","","",""),
        )
        adapter.submitList(list)
    }

}
