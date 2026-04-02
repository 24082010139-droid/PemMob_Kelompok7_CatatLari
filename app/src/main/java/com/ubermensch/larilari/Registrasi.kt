package com.ubermensch.larilari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ubermensch.larilari.databinding.FragmentRegistrasiBinding

class Registrasi : Fragment() {

    private var _binding: FragmentRegistrasiBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout menggunakan View Binding
        _binding = FragmentRegistrasiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handling tombol Sign Up
        binding.btnSignup.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (nama.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Semua kolom harus diisi, bro!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (password.length < 6) {
                    Toast.makeText(
                        requireContext(),
                        "Password minimal 6 karakter!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Registrasi Berhasil! Selamat datang, $nama",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Berpindah ke halaman Beranda setelah registrasi berhasil
                    findNavController().navigate(R.id.beranda)
                }
            }
        }

        binding.tvLogin.setOnClickListener {
            // Kembali ke halaman sebelumnya (Welcome Screen)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}