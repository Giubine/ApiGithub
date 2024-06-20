package com.example.apigithub.domain.usecase

import com.example.apigithub.data.model.PullRequest
import com.example.apigithub.domain.repository.GitHubRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetPullRequestsUseCase @Inject constructor(
    private val repository: GitHubRepository
) {
    fun execute(owner: String, repo: String): Single<List<PullRequest>> =
        repository.getPullRequests(owner, repo)
}