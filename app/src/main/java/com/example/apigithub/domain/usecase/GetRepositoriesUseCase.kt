package com.example.apigithub.domain.usecase

import com.example.apigithub.domain.repository.GitHubRepository
import com.example.apigithub.data.model.GitHubResponse
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetRepositoriesUseCase @Inject constructor(
    private val repository: GitHubRepository
) {
    fun execute(query: String, sort: String, page: Int): Single<GitHubResponse> =
        repository.getRepositories(query, sort, page)
}