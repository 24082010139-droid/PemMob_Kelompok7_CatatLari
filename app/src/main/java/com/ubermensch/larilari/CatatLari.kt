package com.ubermensch.larilari

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ubermensch.larilari.databinding.FragmentCatatLariBinding

class CatatLari : Fragment() {

    private var _binding: FragmentCatatLariBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatatLariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            // 1. Ambil inputan dari form
            val inputTanggal = binding.etTanggal.text.toString()
            val inputJarak = binding.etJarak.text.toString()
            val inputDurasi = binding.etDurasi.text.toString()

            // 2. TAMPUNG ke dalam data class
            val dataBaru = LariData(inputTanggal, inputJarak, inputDurasi)

            // 3. (Opsional) Cek di Logcat apakah datanya sudah masuk
            println("Data Lari: $dataBaru")

            // Di sini kamu bisa lanjutin buat simpan ke database atau kirim ke server
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class DataLari(
    val jarak: String,
    val waktu: String,
    val tanggal: String
)