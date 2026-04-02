package com.ubermensch.larilari

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ubermensch.larilari.databinding.FragmentLoginBinding

class Login : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handling tombol Login
        binding.btnLogin.setOnClickListener {
            val emailUser = binding.etEmail.text.toString()
            val passwordUser = binding.etPassword.text.toString()

            if (emailUser.isEmpty() || passwordUser.isEmpty()) {
                Toast.makeText(requireContext(), "Silahkan masukkan email/password, bro!", Toast.LENGTH_SHORT).show()
            } else {
                // Cek password
                if (passwordUser != "123456") {
                    Toast.makeText(requireContext(), "Password Anda salah!", Toast.LENGTH_SHORT).show()
                } else {
                    // Membuat objek User dari data class (Data tersimpan di variabel userLogin)
                    val userLogin = User(email = emailUser, password = passwordUser)

                    Toast.makeText(requireContext(), "Login Berhasil sebagai ${userLogin.email}", Toast.LENGTH_SHORT).show()

                    // Berpindah ke Beranda
                    findNavController().navigate(R.id.action_login_to_beranda2)
                }
            }
        }

        // Handling klik "Belum punya akun? Daftar"
        binding.tvGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.registrasi)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
