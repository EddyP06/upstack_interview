package com.eddy.upstackinterviewapp.ui.features.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.eddy.upstackinterviewapp.R
import com.eddy.upstackinterviewapp.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val viewModel: LoginVIewModel by viewModel()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.storeCredentials(binding.pass.text.toString(), binding.username.toString())
            viewModel.login()
        }

        viewModel.listData.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            viewModel.storeCredentials("", "")
            Toast.makeText(requireContext(), "Wrong credentials", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}