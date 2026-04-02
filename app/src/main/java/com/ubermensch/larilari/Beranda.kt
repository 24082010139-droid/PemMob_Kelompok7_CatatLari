package com.ubermensch.larilari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ubermensch.larilari.databinding.FragmentBerandaBinding

class Beranda : Fragment() {
        private var _binding: FragmentBerandaBinding? = null
        private val binding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentBerandaBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            // Logika saat tombol Floating Action Button (FAB) diklik
            binding.catatLari.setOnClickListener {
                findNavController().navigate(R.id.action_beranda_to_catatLari)
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }