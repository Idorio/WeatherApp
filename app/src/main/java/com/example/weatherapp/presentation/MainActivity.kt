package com.example.weatherapp.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.presentation.details.DetailsFragment
import com.example.weatherapp.presentation.routes.AppRoutes
import com.example.weatherapp.presentation.search.SearchFragment
import com.example.weatherapp.presentation.wheather.WeatherFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        viewModel.navRoute.observe(this) {
            Log.d("ROUTER", it.toString())
            when(it){
                is AppRoutes.Details -> {
                    DetailsFragment.newInstance(it.model).navigate()
                }
                AppRoutes.Search -> {
                    SearchFragment().navigate()
                }
                is AppRoutes.Weather -> {
                    WeatherFragment.newInstance(it.city).navigate()
                }
            }
        }
    }

    private fun Fragment.navigate() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, this)
            .addToBackStack(null)
            .commit()
    }

}