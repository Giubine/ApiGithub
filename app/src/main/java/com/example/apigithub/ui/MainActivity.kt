package com.example.apigithub.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apigithub.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: RepositoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repositoryAdapter = RepositoryAdapter(emptyList()) { repository ->
            val intent = Intent(this, PullRequestsActivity::class.java).apply {
                putExtra("REPO_NAME", repository.name)
                putExtra("OWNER_NAME", repository.owner.login)
            }
            startActivity(intent)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = repositoryAdapter
        }

        viewModel.repositories.observe(this) { repositories ->
            repositoryAdapter.updateData(repositories)
        }

        viewModel.getRepositories()
    }
}
