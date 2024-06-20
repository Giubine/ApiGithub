package com.example.apigithub.data.repository

import com.example.apigithub.data.api.GitHubApiService
import com.example.apigithub.data.model.GitHubResponse
import com.example.apigithub.data.model.PullRequest
import com.example.apigithub.domain.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val apiService: GitHubApiService
) : GitHubRepository {
    override fun getRepositories(query: String, sort: String, page: Int): Single<GitHubResponse> =
        apiService.getRepositories(query, sort, page)

    override fun getPullRequests(owner: String, repo: String): Single<List<PullRequest>> =
        apiService.getPullRequests(owner, repo)
}