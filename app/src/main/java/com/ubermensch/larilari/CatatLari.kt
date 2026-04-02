package com.ubermensch.larilari

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ubermensch.larilari.databinding.FragmentCatatLariBinding
import java.util.Calendar
import android.widget.Toast
import androidx.navigation.fragment.findNavController

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

            // Fitur Pilih Tanggal (Date Picker)
            binding.etTanggal.setOnClickListener {
                val calendar = Calendar.getInstance()
                val year = calendar.get(Calendar.YEAR)
                val month = calendar.get(Calendar.MONTH)
                val day = calendar.get(Calendar.DAY_OF_MONTH)

                val datePickerDialog = DatePickerDialog(
                    requireContext(),
                    { _, selectedYear, selectedMonth, selectedDay ->
                        val formattedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                        binding.etTanggal.text = formattedDate
                    },
                    year,
                    month,
                    day
                )
                datePickerDialog.show()
            }

            // Tombol Simpan
            binding.btnSave.setOnClickListener {
                val tanggal = binding.etTanggal.text.toString()
                val jarakStr = binding.etJarak.text.toString()
                val durasiStr = binding.etDurasi.text.toString()

                if (tanggal.isEmpty() || jarakStr.isEmpty() || durasiStr.isEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "Harap isi semua data, ya!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Konversi input ke tipe data yang sesuai
                    val jarak = jarakStr.toDoubleOrNull() ?: 0.0
                    val durasi = durasiStr.toIntOrNull() ?: 0

                    // Masukkan ke dalam Data Class
                    val aktivitasBaru = LariData(tanggal, jarak, durasi)

                    // Menampilkan Toast sebagai bukti data tertampung (Bisa diteruskan ke Database/API nanti)
                    Toast.makeText(
                        requireContext(),
                        "Data Tersimpan: ${aktivitasBaru.jarak} km dalam ${aktivitasBaru.durasi} menit",
                        Toast.LENGTH_LONG
                    ).show()

                    // Kembali ke halaman beranda
                    findNavController().popBackStack()
                }
            }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }