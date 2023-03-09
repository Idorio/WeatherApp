package com.example.weatherapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.data.adapter.WeatherAdapter
import com.example.weatherapp.databinding.FragmentDaysBinding
import com.example.weatherapp.model.WeatherModel


class DaysFragment : Fragment() {
    private  var _binding: FragmentDaysBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter : WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentDaysBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}