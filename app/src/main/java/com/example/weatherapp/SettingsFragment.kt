package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSettingBinding
import dagger.hilt.android.AndroidEntryPoint


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        viewModel.nav.observe(viewLifecycleOwner){
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, WeatherFragment())
                .commit()
        }
    }
}
