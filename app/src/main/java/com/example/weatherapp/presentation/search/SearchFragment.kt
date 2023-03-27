package com.example.weatherapp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSettingBinding
import com.example.weatherapp.presentation.MainViewModel
import com.example.weatherapp.presentation.routes.AppRoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()
    private val navViewModel by activityViewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToMainFragment.setOnClickListener {
            viewModel.enterCity(
                binding.etText.text.toString()
            )
        }

        viewModel.nav.observe(viewLifecycleOwner) {
            navViewModel.navigate(AppRoutes.Weather(city = it))
        }
    }
}
