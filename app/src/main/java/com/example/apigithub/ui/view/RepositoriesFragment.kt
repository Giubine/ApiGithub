package com.example.apigithub.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apigithub.databinding.FragmentRepositoriesBinding
import com.example.apigithub.ui.adapter.RepositoriesAdapter
import com.example.apigithub.ui.viewmodel.RepositoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RepositoriesFragment : Fragment() {

    private var _binding: FragmentRepositoriesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RepositoriesViewModel by viewModels()
    private val adapter = RepositoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.repositories.observe(viewLifecycleOwner) { response ->
            adapter.submitList(response)
        }

        viewModel.fetchRepositories("Java", "stars", 1)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
