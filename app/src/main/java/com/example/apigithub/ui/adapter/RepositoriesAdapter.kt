package com.example.apigithub.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.apigithub.data.model.Repository
import com.example.apigithub.databinding.ItemRepositoryBinding

class RepositoriesAdapter : ListAdapter<Repository, RepositoriesAdapter.RepositoryViewHolder>(
    RepositoryDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class RepositoryViewHolder(private val binding: ItemRepositoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repository: Repository) {
            binding.repository = repository
            binding.executePendingBindings()
        }
    }

    class RepositoryDiffCallback : DiffUtil.ItemCallback<Repository>() {
        override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
            return oldItem == newItem
        }
    }
}
