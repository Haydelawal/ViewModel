package com.example.exposed_drop_down_ss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.exposed_drop_down_ss.databinding.ActivityMainBinding
import com.example.exposed_drop_down_ss.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onResume() {
        super.onResume()
        val languages = resources.getStringArray(R.array.languages)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, languages)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.buttonClick.setOnClickListener {

            val selectedLanguage= binding.autoCompleteTextView.text.toString()
            val intent = Intent(context, ThirdActivity::class.java)

            when (selectedLanguage) {
                "Chinese" -> startActivity(intent)
//                    requireView().findNavController()
//                    .navigate(R.id.action_firstFragment_to_exampleFragment
//                    )
                "German" -> requireView().findNavController()
                    .navigate(R.id.action_firstFragment_to_exampleTwoFragment
                    )
                else -> {
                    Toast.makeText(requireContext(), "English", Toast.LENGTH_SHORT).show()
                }
            }

        }
        return binding.root


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
