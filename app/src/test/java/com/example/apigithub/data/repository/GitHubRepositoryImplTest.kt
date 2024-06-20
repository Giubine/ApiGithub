package com.example.apigithub.data.repository

import com.example.apigithub.data.api.GitHubApiService
import com.example.apigithub.data.model.GitHubResponse
import com.example.apigithub.data.model.PullRequest
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Before
import org.junit.Test

class GitHubRepositoryImplTest {

    private lateinit var repository: GitHubRepositoryImpl
    private val gitHubService: GitHubApiService = mockk()

    @Before
    fun setUp() {
        repository = GitHubRepositoryImpl(gitHubService)
    }

    @Test
    fun `getRepositories should return GitHubResponse`() {
        val response = GitHubResponse(listOf(mockk()))
        every { gitHubService.getRepositories(any(), any(), any()) } returns Single.just(response)

        val result = repository.getRepositories("language:Java", "stars", 1).blockingGet()

        assert(result == response)
    }

    @Test
    fun `getPullRequests should return list of PullRequests`() {
        val pullRequests = listOf(mockk<PullRequest>())
        every { gitHubService.getPullRequests(any(), any()) } returns Single.just(pullRequests)

        val result = repository.getPullRequests("owner", "repo").blockingGet()

        assert(result == pullRequests)
    }
}
