package com.example.apigithub.domain.repository

import com.example.apigithub.data.model.GitHubResponse
import com.example.apigithub.data.model.PullRequest
import io.reactivex.rxjava3.core.Single

interface GitHubRepository {
    fun getRepositories(query: String, sort: String, page: Int): Single<GitHubResponse>
    fun getPullRequests(owner: String, repo: String): Single<List<PullRequest>>
}